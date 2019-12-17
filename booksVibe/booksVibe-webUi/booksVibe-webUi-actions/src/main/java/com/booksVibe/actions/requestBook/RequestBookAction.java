package com.booksVibe.actions.requestBook;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.actions.constants.ActionConstants;
import com.booksVibe.actions.helper.ActionHelper;

import com.booksVibe.models.BooksBean;
import com.booksVibe.models.RequestBookBean;
import com.booksVibe.models.UserBean;
import com.booksVibe.service.books.BooksManager;
import com.booksVibe.service.exceptions.BookAlreadyRequestedException;
import com.booksVibe.service.exceptions.RequestNotAllowedException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.exceptions.SubscriptionPlanExpiredServiceException;
import com.booksVibe.service.requestBook.RequestBookManager;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.booksVibe.util.exception.UtilException;
import com.booksVibe.util.mail.SendEmail;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestBookAction.
 */
public class RequestBookAction extends ActionSupport implements
        ModelDriven<RequestBookBean> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The request bean. */
    @Autowired
    private RequestBookBean requestBean;

    /** The request book manager. */
    @Autowired
    private RequestBookManager requestBookManager;

    /** The request vo. */
    @Autowired
    private RequestBookVO requestVO;

    /** The books bean. */
    @Autowired
    private BooksBean booksBean;

    /** The books vo. */
    @Autowired
    private BooksVO booksVO;

    /** The user value object. */
    @Autowired
    private UserValueObject userValueObject;

    /** The send. */
    @Autowired
    private SendEmail send;

    /** The books manager. */
    @Autowired
    private BooksManager booksManager;
    
    /** The Constant BOOK_ID. */
    private static final String BOOK_ID="bookId";
    
    /** The Constant REQUESTED_FROM_PAGE. */
    private static final String REQUESTED_FROM_PAGE="requestedFrom",USER_BEAN="userBean";

    /** The logger. */
    private static final Logger LOGGER = Logger.getLogger(RequestBookAction.class);

    /**
     * Request book.
     * This method places user's book request.
     * @return the string
     */
    public String requestBook()
    {
    try {

            UserBean userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute(USER_BEAN);
            booksBean.setBookId(requestBean.getBookId());

            transferDataFromActionToService(userBean);

            requestBookManager.requestBook(requestVO);

            addActionMessage(getText("Book.Requested"));
            booksVO = booksManager.booksById(requestBean.getBookId());
            send.requestMail(userBean, booksVO, "PendingRequest");

            String requestedFrom = ServletActionContext.getRequest().getParameter(REQUESTED_FROM_PAGE);
            return redirectToPage(requestedFrom);
        } 
        catch (BookAlreadyRequestedException e) 
        {
            LOGGER.info("BOOK ALREADY REQUESTED BY THE USER." + e);
            addActionMessage(getText("AlreadyRequested"));
            String requestedFrom = ServletActionContext.getRequest().getParameter("requestedFrom");
            return redirectToPage(requestedFrom);
        }
        catch (RequestNotAllowedException e) 
        {
            LOGGER.info("REQUEST COUNT EXCEEDED THE MAX BOOK LIMIT" + e);
            addActionMessage(getText("MaxBookRequested"));
            String requestedFrom = ServletActionContext.getRequest().getParameter(REQUESTED_FROM_PAGE);
            return redirectToPage(requestedFrom);
        } 
        catch (SubscriptionPlanExpiredServiceException e)
        {
            LOGGER.info("USERS SUBSCRIPTION PLAN IS EXPIRED" + e);
            addActionMessage(getText("PlanExpired"));
            String requestedFrom = ServletActionContext.getRequest().getParameter(REQUESTED_FROM_PAGE);
            return redirectToPage(requestedFrom);
            
        }
        catch (ServiceException e)
        {
            LOGGER.error("EXCEPTION IN SERVICELAYER AT ACTION" + e);
            return ActionConstants.FAILURE;

        } 
        catch (UtilException e)
        {
            LOGGER.info("UTIL EXCEPTION "+e);
            String requestedFrom = ServletActionContext.getRequest().getParameter(REQUESTED_FROM_PAGE);
            return redirectToPage(requestedFrom);
        } 
        catch (Exception e)
        {
            LOGGER.error("EXCEPTION IN ACTION " + e);
            return ActionConstants.FAILURE;

        }

    }
    

    /**
     * Transfer data from action to service.
     *
     * @param userBean the user bean
     */
    private void transferDataFromActionToService(UserBean userBean)
    {
        booksVO = ActionHelper.booksTransfer(booksVO, booksBean);
        userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);

        requestVO.setUserVO(userValueObject);
        requestVO.setBooksVO(booksVO);
        requestVO.setAddress(requestBean.getAddress());
        requestVO.setBookId(requestBean.getBookId());
    }

    /**
     * View requested books.
     * This method fetches all the requested books by a user.
     * @return the string
     */
    public String viewRequestedBooks()
    {
        try {

            UserBean userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute(USER_BEAN);
            userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);

            requestVO.setUserVO(userValueObject);
            requestVO.setBooksVO(booksVO);

            List<RequestBookVO> requestedBookListVO = requestBookManager.viewRequestedBooks(requestVO);

            List<RequestBookBean> requestedBooksListBean = new ArrayList<RequestBookBean>();

            requestedBooksListBean = ActionHelper.requestedBooksListTransferServiceToAction(requestedBookListVO, requestedBooksListBean);

            LOGGER.info("books list in action" + requestedBooksListBean);

            List<BooksBean> requestedBooksList = ActionHelper.requestedBooksListTransfer(requestedBooksListBean);

            LOGGER.info("SIZE OF LIST IN ACTION" + requestedBooksList);
            HttpServletRequest request = ServletActionContext.getRequest();

            request.setAttribute("requestedBooksList", requestedBooksList);

            return SUCCESS;

        }
        catch (ServiceException e)
        {
            return ActionConstants.FAILURE;
        } 
        catch (Exception e)
        {
            return ActionConstants.FAILURE;
        }

    }

    /**
     * View issued books.
     * This method  fetches all the book issued by a user.
     * @return the string
     */
    public String viewIssuedBooks() {
        try {

            UserBean userBean = (UserBean) ServletActionContext.getRequest() .getSession().getAttribute(USER_BEAN);
            userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);

            requestVO.setUserVO(userValueObject);
            requestVO.setBooksVO(booksVO);

            List<RequestBookVO> issuedBookListVO = requestBookManager.viewIssuedBooks(requestVO);

            List<RequestBookBean> issuedBooksListBean = new ArrayList<RequestBookBean>();

            issuedBooksListBean = ActionHelper.requestedBooksListTransferServiceToAction(issuedBookListVO, issuedBooksListBean);

            List<BooksBean> issuedBooksList = ActionHelper.requestedBooksListTransfer(issuedBooksListBean);

            LOGGER.info("SIZE OF LIST IN ACTION" + issuedBooksList);
            HttpServletRequest request = ServletActionContext.getRequest();

            request.setAttribute("requestedBooksList", issuedBooksList);

            return SUCCESS;

        } 
        catch (ServiceException e)
        {
            return ActionConstants.FAILURE;
        } 
        catch (Exception e)
        {
            return ActionConstants.FAILURE;
        }

    }

    /**
     * Cancel delivery request.
     * This method cancels a delivery request.
     * @return the string
     */
    public String cancelDeleiveryRequest()
    {
     try {
           
            UserBean userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute(USER_BEAN);
            LOGGER.info("USER EMAILD ID:" + userBean.getEmaild());

            int bookId = Integer.parseInt(ServletActionContext.getRequest().getParameter(BOOK_ID));
            booksBean.setBookId(bookId);
            LOGGER.info("BOOK ID:" + booksBean.getBookId());

            booksVO = ActionHelper.booksTransfer(booksVO, booksBean);

            userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);

            requestVO.setUserVO(userValueObject);
            requestVO.setBooksVO(booksVO);

            
            requestBookManager.cancelDeleiveryRequest(requestVO);
            booksVO = booksManager.booksById(bookId);
            addActionMessage(getText("RequestCancelled"));
            send.requestMail(userBean, booksVO, "cancelDeleivery");

            return SUCCESS;
        }
        catch (ServiceException e) 
        {
            return ActionConstants.FAILURE;
        } 
        catch (UtilException e)
        {
            return SUCCESS;
        } 
        catch (Exception e)
        {
            return ActionConstants.FAILURE;
        }
    }

    /**
     * Book return request.
     * This method places  return request for a book.
     * @return the string
     */
    public String bookReturnRequest()
    {
     try {

            UserBean userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute(USER_BEAN);

            int bookId = Integer.parseInt(ServletActionContext.getRequest().getParameter(BOOK_ID));
            booksBean.setBookId(bookId);

            booksVO = ActionHelper.booksTransfer(booksVO, booksBean);

            userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);

            requestVO.setUserVO(userValueObject);
            requestVO.setBooksVO(booksVO);
            requestVO.setAddress(requestBean.getAddress());

            requestBookManager.bookReturnRequest(requestVO);
            booksVO = booksManager.booksById(bookId);

            addActionMessage(getText("ReturnRequest"));
            send.requestMail(userBean, booksVO, "return");

            return SUCCESS;
        } 
        catch (ServiceException e) 
        {
            return ActionConstants.FAILURE;
        } 
        catch (UtilException e) 
        {
            return SUCCESS;
        } 
        catch (Exception e)
        {
            return ActionConstants.FAILURE;
        }
    }

    /**
     * View to be returned books.
     * 
     * @return the string
     */
    public String viewToBeReturnedBooks() {
        try {

            UserBean userBean = (UserBean) ServletActionContext.getRequest()
                    .getSession().getAttribute(USER_BEAN);
            userValueObject = ActionHelper.actionToServiceTransfer(userBean,
                    userValueObject);

            requestVO.setUserVO(userValueObject);
            requestVO.setBooksVO(booksVO);

            List<RequestBookVO> toBeReturnedBookListVO = requestBookManager
                    .viewToBeReturnedBooks(requestVO);

            List<RequestBookBean> toBeReturnedBooksListBean = new ArrayList<RequestBookBean>();

            toBeReturnedBooksListBean = ActionHelper
                    .requestedBooksListTransferServiceToAction(
                            toBeReturnedBookListVO, toBeReturnedBooksListBean);

            List<BooksBean> toBeReturnedBooksList = ActionHelper
                    .requestedBooksListTransfer(toBeReturnedBooksListBean);

            LOGGER.info("SIZE OF LIST IN ACTION" + toBeReturnedBooksList);
            HttpServletRequest request = ServletActionContext.getRequest();

            request.setAttribute("requestedBooksList", toBeReturnedBooksList);

            return SUCCESS;

        } catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } catch (Exception e) {
            return ActionConstants.FAILURE;
        }

    }

    /**
     * Cancel return request.
     * This method cancels a return requests.
     * @return the string
     */
    public String cancelReturnRequest() {
        try {

            UserBean userBean = (UserBean) ServletActionContext.getRequest()
                    .getSession().getAttribute(USER_BEAN);

            int bookId = Integer.parseInt(ServletActionContext.getRequest()
                    .getParameter(BOOK_ID));
            booksBean.setBookId(bookId);

            booksVO = ActionHelper.booksTransfer(booksVO, booksBean);

            userValueObject = ActionHelper.actionToServiceTransfer(userBean,
                    userValueObject);

            requestVO.setUserVO(userValueObject);
            requestVO.setBooksVO(booksVO);

            requestBookManager.cancelReturnRequest(requestVO);
            booksVO = booksManager.booksById(bookId);
            addActionMessage(getText("CancelReturnRequest"));

            send.requestMail(userBean, booksVO, "cancelReturn");
            return SUCCESS;
        } catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } catch (UtilException e) {
            return SUCCESS;
        } catch (Exception e) {
            return ActionConstants.FAILURE;
        }
    }

    /**
     * View my history.
     * This method fetches a user's book request history.
     * This history contains all the cancelled books and closed books.
     * @return the string
     */
    public String viewMyHistory() {
        try {

            UserBean userBean = (UserBean) ServletActionContext.getRequest()
                    .getSession().getAttribute(USER_BEAN);

            userValueObject = ActionHelper.actionToServiceTransfer(userBean,
                    userValueObject);
            requestVO.setUserVO(userValueObject);
            requestVO.setBooksVO(booksVO);

            List<RequestBookVO> myHistoryListVO = requestBookManager
                    .viewMyHistory(requestVO);

            List<RequestBookBean> myHistoryListBean = new ArrayList<RequestBookBean>();
            myHistoryListBean = ActionHelper
                    .requestedBooksListTransferServiceToAction(myHistoryListVO,
                            myHistoryListBean);

            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("myHistory", myHistoryListBean);

            return SUCCESS;

        } catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN ACTION WHILE REQUESTING USER HISTORY."+ e);
            return ERROR;
        }

    }

    /**
     * Confirm address.
     * 
     * @return the string
     */
    public String confirmAddress() {
        try {
            LOGGER.info("REDIRECTING TO CONFIRM ADDERSS");
            HttpServletRequest request = ServletActionContext.getRequest();
            int bookId = Integer.parseInt(ServletActionContext.getRequest().getParameter(BOOK_ID));
            request.setAttribute(BOOK_ID,bookId);
            return SUCCESS;

        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN ACTION" + e);
            return ActionConstants.FAILURE;
        }

    }

    /**
     * View my plan.
     *This method fetches user's currently subscribed plan.
     * @return the string
     */
    public String viewMyPlan() {
        try {
            UserBean userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute(USER_BEAN);

            userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);

            UserSubsVO userSubsVO = requestBookManager.viewMyPlan(userValueObject);

            HttpServletRequest request = ServletActionContext.getRequest();
            
            request.setAttribute("subscriptionPlan", userSubsVO);

            return SUCCESS;
        } 
        catch (ServiceException e) {
            return ActionConstants.FAILURE;
        }
        catch (Exception e) {
            return ERROR;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public RequestBookBean getModel() {
        // TODO Auto-generated method stub
        return requestBean;
    }

    
    /**
     * Redirect to page.
     *
     * @param requestedFrom the requested from
     * @return the string
     */
    public String redirectToPage(String requestedFrom)
    {
        if (requestedFrom.equalsIgnoreCase(getText("browseBooks"))) {
            LOGGER.info("REDIRECTING TO BROWSE BOOKS PAGE");
            return ActionConstants.BROWSE_BOOKS_PAGE;
        }
        else if (requestedFrom.equalsIgnoreCase(getText("recommendations"))) {
            LOGGER.info("REDIRECTING TO BROWSE BOOKS PAGE");
            return ActionConstants.RECOMMENDED_BOOKS_PAGE;
        }
        else {
            LOGGER.info("REDIRECTING TO USER SHELF");
            return ActionConstants.SHELF_PAGE;
        }
    }
    
    public String shelfConfirmAddress() {
       try {
            LOGGER.info("REDIRECTING TO CONFIRM ADDERSS");
            HttpServletRequest request = ServletActionContext.getRequest();
            int bookId = Integer.parseInt(ServletActionContext.getRequest().getParameter(BOOK_ID));
            request.setAttribute(BOOK_ID,bookId);
            return SUCCESS;

        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN ACTION  " + e);
            return ActionConstants.FAILURE;
        }

    }
    
    public String recommendedBooksConfirmAddress() {
        try {
             LOGGER.info("REDIRECTING TO CONFIRM ADDERSS");
             HttpServletRequest request = ServletActionContext.getRequest();
             int bookId = Integer.parseInt(ServletActionContext.getRequest().getParameter(BOOK_ID));
             request.setAttribute(BOOK_ID,bookId);
             return SUCCESS;

         } catch (Exception e) {
             LOGGER.error("EXCEPTION IN ACTION:" + e);
             return ActionConstants.FAILURE;
         }

     }
    
}
