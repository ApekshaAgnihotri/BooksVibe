package com.booksVibe.actions.requestHandler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.actions.constants.ActionConstants;
import com.booksVibe.actions.helper.ActionHelper;
import com.booksVibe.models.RequestBookBean;
import com.booksVibe.models.UserBean;
import com.booksVibe.models.UserSubsBean;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.requestHandler.RequestHandlerManager;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestHandler.
 * This class performs actions related to requested handling from admin side.
 */
public class RequestHandler extends ActionSupport implements
        ModelDriven<RequestBookBean> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(RequestHandler.class);

    /** The request bean. */
    @Autowired
    private RequestBookBean requestBean;

    /** The request handler manager. */
    @Autowired
    private RequestHandlerManager requestHandlerManager;

      /** The user value object. */
    @Autowired
    private UserValueObject userValueObject;

    private static final String MASTER="master",USER_BEAN="userBean";
    
    /**
     * View requested books.
     * This method fetches book delivery requests assigned to an admin.
     * @return the string
     */
    public String viewRequestedBooks()
    {
      try 
      {

            LOGGER.info("REQUESTING IN ACTION");
            UserBean userBean = (UserBean) ServletActionContext.getRequest()
                    .getSession().getAttribute(USER_BEAN);
            LOGGER.info("OPERATOR ID:" + userBean.getEmaild());

            userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);
            
            List<RequestBookVO> requestedBooksListVO = requestHandlerManager.viewRequestedBooks(userValueObject);

            List<RequestBookBean> requestedBooksListBean = new ArrayList<RequestBookBean>();

            requestedBooksListBean = ActionHelper
                    .requestedBooksListTransferServiceToAction(
                            requestedBooksListVO, requestedBooksListBean);

            HttpServletRequest request = ServletActionContext.getRequest();

            request.setAttribute("requestedBooksList", requestedBooksListBean);
            if (userBean.getRole().equalsIgnoreCase(MASTER)) {
                return SUCCESS;
            } else {
                return ActionConstants.SLAVE_ADMIN_PAGE;
            }

        } catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } catch (Exception e) {
            return ActionConstants.FAILURE;
        }

    }

    /**
     * View books to be returned.
     * This method fetches book returns requests assigned to an admin
     * @return the string
     */
    public String viewBooksToBeReturned() {
        try {
            UserBean userBean = (UserBean) ServletActionContext.getRequest()
                    .getSession().getAttribute(USER_BEAN);
            LOGGER.info("OPERATOR ID:" + userBean.getEmaild());
            userValueObject = ActionHelper.actionToServiceTransfer(userBean,
                    userValueObject);

            List<RequestBookVO> requestedBooksListVO = requestHandlerManager
                    .viewBooksToBeReturned(userValueObject);

            List<RequestBookBean> requestedBooksListBean = new ArrayList<RequestBookBean>();

            requestedBooksListBean = ActionHelper
                    .requestedBooksListTransferServiceToAction(
                            requestedBooksListVO, requestedBooksListBean);

            HttpServletRequest request = ServletActionContext.getRequest();

            request.setAttribute("requestedBooksList", requestedBooksListBean);

            if (userBean.getRole().equalsIgnoreCase(MASTER)) {
                return SUCCESS;
            } else {
                return ActionConstants.SLAVE_ADMIN_PAGE;
            }

        } catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } catch (Exception e) {
            return ActionConstants.FAILURE;
        }
    }

    /**
     * Approve delivery request.
     * This method approves a delivery request.
     * @return the string
     */
    public String approveDeleiveryRequest() {
        try {

            int requestId = Integer.parseInt(ServletActionContext.getRequest()
                    .getParameter("requestId"));

            requestHandlerManager.approveDeleiveryRequest(requestId);

            addActionMessage(getText("RequestApproved"));

            UserBean userBean = (UserBean) ServletActionContext.getRequest()
                    .getSession().getAttribute(USER_BEAN);
            if (userBean.getRole().equalsIgnoreCase(MASTER)) {
                return SUCCESS;
            } else {
                return ActionConstants.SLAVE_ADMIN_PAGE;
            }
        } catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN ACTION WHILE APPROVING DELEIVERY REQUEST"
                    + e);
            return ActionConstants.FAILURE;
        }
    }

    /**
     * Close return request.
     * 
     * @return the string
     */
    public String closeReturnRequest() {
        try {

            int requestId = Integer.parseInt(ServletActionContext.getRequest()
                    .getParameter("requestId"));

            requestHandlerManager.closeReturnRequest(requestId);

            addActionMessage(getText("RequestClosed"));

            UserBean userBean = (UserBean) ServletActionContext.getRequest()
                    .getSession().getAttribute(USER_BEAN);
            if (userBean.getRole().equalsIgnoreCase(MASTER)) {
                return SUCCESS;
            } else {
                return ActionConstants.SLAVE_ADMIN_PAGE;
            }
        } catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN ACTION WHILE CLOSING RETURN REQUEST ");
            return ActionConstants.FAILURE;
        }
    }

    /**
     * View users.
     * This method fetches all the active users.
     * @return the string
     */
    public String viewUsers() {
        try {

            List<UserSubsVO> userListVO = requestHandlerManager.viewUsers();

            LOGGER.info("LIST SIZE RETRIEVED FROM SERVICE:" + userListVO.size());
            List<UserSubsBean> usersListBean = new ArrayList<UserSubsBean>();
            usersListBean = ActionHelper.usersSubsDetailsTransfer(userListVO,
                    usersListBean);

            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("usersList", usersListBean);
            return SUCCESS;

        } catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } catch (Exception e) {
            return ActionConstants.FAILURE;
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

}
