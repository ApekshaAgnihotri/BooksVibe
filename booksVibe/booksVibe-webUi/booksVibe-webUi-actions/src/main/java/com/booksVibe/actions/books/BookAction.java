package com.booksVibe.actions.books;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.actions.constants.ActionConstants;
import com.booksVibe.actions.helper.ActionHelper;
import com.booksVibe.models.BooksBean;
import com.booksVibe.models.ListCarrierBean;
import com.booksVibe.models.UserBean;
import com.booksVibe.service.books.BooksManager;
import com.booksVibe.service.exceptions.NoDeleteServiceException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.ListCarrierVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class BookAction. This class performs action related to a book. It adds a
 * new book, updates a book , search books etc.
 */
public class BookAction extends ActionSupport implements ModelDriven<BooksBean> {

    /** The logger. */
    private static final Logger LOGGER = Logger.getLogger(BookAction.class);

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The request. */
    private HttpServletRequest request = ServletActionContext.getRequest();

    /** The session. */
    private HttpSession session = request.getSession();

    /** The property file. */
    private String propertyFile = "path.properties",userEmailId;

    /** The books bean. */
    @Autowired
    private BooksBean booksBean;

    /** The books vo. */
    @Autowired
    private BooksVO booksVO;

    /** The books manager. */
    @Autowired
    private BooksManager booksManager;

    /** The operator. */
    @Autowired
    private UserValueObject operator;
    
    /** The user bean. */
    @Autowired
    private UserBean userBean;

    /** The size. */
    private static final int SIZE = 6;
    
    /** The Constant USER_BEAN. */
    private static final String USER_BEAN="userBean";

    /**
     * Adds the books. This method inserts a new book in the library.
     * 
     * @return the string
     */
    public String addBooks() 
    {
     try {

            Properties property = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);
            property.load(inputStream);
            String path = property.getProperty("imagePath");

            File fileToCreate = new File(path, booksBean.getKimageFileName());
            FileUtils.copyFile(booksBean.getKimage(), fileToCreate);

            userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute(USER_BEAN);

            operator = ActionHelper.actionToServiceTransfer(userBean, operator);
            booksVO = ActionHelper.booksTransfer(booksVO, booksBean);
            
            
            Boolean status = booksManager.addBooks(booksVO, operator);

            if (status) 
            {
                addActionMessage(getText("BookAdded"));
                return ActionConstants.BOOKS_PAGE;
                
            } 
            else 
            {
                addActionError(getText("BookNotAdded"));
                return ActionConstants.BOOKS_PAGE;
            }

        } 
        catch (ServiceException e) 
        {
            return ActionConstants.FAILURE;
        }
        catch (Exception e) 
        {
            LOGGER.error("EXCEPTION WHILE ADDING BOOKS" + e);
            return ActionConstants.FAILURE;
        }
    }

    /**
     * Books by id. This method returns book details fetched from its id.
     * 
     * @return the string
     */
    public String booksById() 
    {
     try {

            booksVO = booksManager.booksById(Integer.parseInt(request.getParameter("bookId")));

            booksBean = ActionHelper.booksDetailsTransfer(booksVO, booksBean);
            LOGGER.info("FOUND BOOK");

            return ActionConstants.UPDATE_PAGE;
            
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
     * Update books. This method updates book details
     * 
     * @return the string
     */
    public String updateBook()
    {
      try {
             LOGGER.info("UPDATING BOOKS IN ACTION");
             booksVO = ActionHelper.booksTransfer(booksVO, booksBean);

              booksManager.updateBooks(booksVO);

              addActionMessage(getText("BookUpdated"));
              return ActionConstants.UPDATE_BOOKS;

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
     * Delete books. This method deletes a book
     * 
     * @return the string
     */
    public String deleteBook() 
    {
     try
     {
         booksManager.deleteBooks(Integer.parseInt(request.getParameter("bookId")));
         addActionMessage(getText("BookDeleted"));

            return SUCCESS;
      } 
      catch (NoDeleteServiceException e)
      {
            addActionError(getText("Delete.Abort"));
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
     * Addbook page. This method returns the addBook Page
     * 
     * @return the string
     */
    public String addBooksPage()
    {
        return ActionConstants.ADD_BOOKS;
    }

    /**
     * Search books. This method perform searching action. Also it loads the new
     * arrivals.
     * 
     * @return the string
     */
    public String searchBooks()
    {
     try {

            String pageNumber = request.getParameter((new ParamEncoder("row").encodeParameterName(TableTagParameters.PARAMETER_PAGE)));
            LOGGER.info("pageNumber" + pageNumber);

            int curPage = 0;
            int requestId = 2;
              if (pageNumber == null) 
               {
                  curPage = 1;
                  requestId = Integer.parseInt(request.getParameter("requestId"));
               }
               else {
                  curPage = Integer.parseInt(pageNumber);
                  requestId = Integer.parseInt(request.getParameter("requestId"));
               }

            int start = (curPage - 1) * SIZE;
              
                  if (requestId == 1) 
                  {
                     return callNewArrivals();
                
                   }
                  else
                  {
                     booksVO = ActionHelper.booksTransfer(booksVO, booksBean);
                     return callSearchBooks(start);
                  }
        } 
        catch (ServiceException e)
        {
            return ActionConstants.FAILURE;
        } 
        catch (Exception e) 
        {
            LOGGER.error("EXCEPTION IN SEARCHING BOOKS" + e);
            return ERROR;
        }
    }

    /**
     * Call search books.
     *
     * @param start the start
     * @return the string
     * @throws ServiceException the service exception
     */
    private String callSearchBooks(int start) throws ServiceException 
    {
        ListCarrierVO listCarrierVO = new ListCarrierVO();
        List<BooksVO> booksListVO=new ArrayList<BooksVO>();
        
        if(session.getAttribute("userBean")!=null)
        {
            LOGGER.info("INSIDE IF*********");
            userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute(USER_BEAN);
             userEmailId=userBean.getEmaild();
            listCarrierVO = booksManager.searchBooks(booksVO, start,userEmailId);
        }
        else
        {
            listCarrierVO = booksManager.searchBooks(booksVO, start,userEmailId);
        }
          ListCarrierBean listCarrierBean = new ListCarrierBean();
          List<BooksBean> booksListBean = new ArrayList<BooksBean>();
          booksListVO = (List<BooksVO>) listCarrierVO.getBooksListVO();
          booksListBean = ActionHelper.booksListTransfer(booksListVO,booksListBean);
          int totalRecords = (int) listCarrierVO.getTotalRecords();
          listCarrierBean.setTotalRecords(totalRecords);
          listCarrierBean.setBooksListBean(booksListBean);
       
        session.setAttribute("ListCarrier",listCarrierBean.getBooksListBean());
        session.setAttribute("Records",listCarrierBean.getTotalRecords());
        
        String requestedBy = ServletActionContext.getRequest().getParameter("requestedBy");
        return redirectToPage(requestedBy);
    }

    
    /**
     * Call new arrivals.
     *
     * @return the string
     * @throws ServiceException the service exception
     */
    private String callNewArrivals() throws ServiceException 
    {
        List<BooksVO> booksListVO;
        if(session.getAttribute("userBean")!=null)
        {
               userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute(USER_BEAN);
               userEmailId=userBean.getEmaild();
                booksListVO = booksManager.newArrivals(userEmailId);
        }
         else
         {
                booksListVO = booksManager.newArrivals(userEmailId);  
         }
            List<BooksBean> booksListBean = new ArrayList<BooksBean>();
            booksListBean = ActionHelper.booksListTransfer(booksListVO, booksListBean);
           
            session.setAttribute("ListCarrier", booksListBean);
            session.setAttribute("Records", booksListBean.size());
            
            String requestedBy = ServletActionContext.getRequest().getParameter("requestedBy");
            return redirectToPage(requestedBy);
    }

    
    /**
     * Redirect to page.
     *  
     * @param requestedBy the requested by
     * @return the string
     */
    public String redirectToPage(String requestedBy)
    {
        if (requestedBy.equalsIgnoreCase("masterAdmin"))
        {
           return ActionConstants.MASTER_BROWSE_BOOKS_PAGE;
        }
        else if (requestedBy.equalsIgnoreCase("user"))
        {
            return ActionConstants.USER_BROWSE_BOOKS;
        }
        else
        {
            return ActionConstants.ANNONYMOUS_BROWSE_PAGE;
        }
    }
    
    
    
    
    
       /**
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public BooksBean getModel() {
        // TODO Auto-generated method stub
        return booksBean;
    }
    
    /**
     * Fetch new arrivals.
     * This method fetches newly arrived books.
     * @return the string
     */
    public String fetchNewArrivals()
    {
     try{
            userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute(USER_BEAN);
            userEmailId=userBean.getEmaild();
             List<BooksVO> booksListVO = booksManager.newArrivals(userEmailId);
             List<BooksBean> booksListBean = new ArrayList<BooksBean>();
             booksListBean = ActionHelper.booksListTransfer(booksListVO, booksListBean);
             LOGGER.info("LIST IN ACTION:" + booksListBean.size());
             session.setAttribute("newArrivalsList", booksListBean);
                         
             return SUCCESS;
        }
        catch(ServiceException e)
        {
            return ActionConstants.FAILURE;
        }
        catch(Exception e)
        {
            return ActionConstants.FAILURE;
        }
    }

}
