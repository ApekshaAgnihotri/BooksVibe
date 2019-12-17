package com.booksVibe.actions.userBookShelf;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.actions.constants.ActionConstants;
import com.booksVibe.actions.helper.ActionHelper;
import com.booksVibe.models.BooksBean;
import com.booksVibe.models.UserBean;
import com.booksVibe.models.UserBookShelfBean;
import com.booksVibe.service.exceptions.AlreadyInShelfServiceException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.userBookShelf.UserBookShelfManager;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.UserBookShelfVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class UserBookShelfAction.
 */
public class UserBookShelfAction extends ActionSupport implements  ModelDriven<UserBookShelfBean> {

    /** The user value object. */
    @Autowired
    private UserValueObject userValueObject;

    /** The books vo. */
    @Autowired
    private BooksVO booksVO;

    /** The books bean. */
    @Autowired
    private BooksBean booksBean;

    /** The cart bean. */
    @Autowired
    private UserBookShelfBean userBookShelfBean;

    /** The cart vo. */
    @Autowired
    private UserBookShelfVO userBookShelfVO;

    /** The cart manager. */
    @Autowired
    private UserBookShelfManager userBookShelfManager;

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(UserBookShelfAction.class);

    /** The request. */
    HttpServletRequest request = ServletActionContext.getRequest();
    /**
     * User Book Shelf actions.
     * This methods add a book in a user's shelf and deletes a book from user's shelf
     * @return the string
     */
    public String userBookShelfAction() 
    {
     try {
             UserBean userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute("userBean");
             int bookId = Integer.parseInt(ServletActionContext.getRequest().getParameter("bookId"));
             String requestType = ServletActionContext.getRequest().getParameter("requestType");
            
             booksBean.setBookId(bookId);
             userBookShelfBean.setBooksBean(booksBean);
             userBookShelfBean.setUserBean(userBean);

             userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);
             booksVO = ActionHelper.booksTransfer(booksVO, booksBean);
             userBookShelfVO.setBooksVO(booksVO);
             userBookShelfVO.setUserVO(userValueObject);

                 if (requestType.equalsIgnoreCase("addToShelf")) 
                 {
                       userBookShelfManager.addToShelf(userBookShelfVO);
                       addActionMessage(getText("BookAddedInShelf"));
                  
                        return SUCCESS;
                 }
                 else 
                 {
                       userBookShelfManager.deleteFromShelf(userBookShelfVO);
                       addActionMessage(getText("BookDeletedFromShelf"));
                
                       return SUCCESS;
                 }

        }
        catch (AlreadyInShelfServiceException e) 
        {
            addActionError(getText("BookAlreadyInShelf"));
            return ERROR;
        }
        catch (ServiceException e) 
        {
            return ActionConstants.FAILURE;
        }
        catch (Exception e) 
        {
            LOGGER.error("EXCEPTION IN ACTION" + e);
            return ActionConstants.FAILURE;
        }

    }

    /**
     * View my Shelf.
     * 
     * @return the string
     */
    public String viewMyShelf() 
    {
     try {
           
              LOGGER.info("VIEWING SHELF*");
               UserBean userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute("userBean");
               userBookShelfBean.setBooksBean(booksBean);
               userBookShelfBean.setUserBean(userBean);

               userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);
               booksVO = ActionHelper.booksTransfer(booksVO, booksBean);
               userBookShelfVO.setBooksVO(booksVO);
               userBookShelfVO.setUserVO(userValueObject);

            
                List<UserBookShelfVO> booksInCartVO = userBookShelfManager.viewMyShelf(userBookShelfVO);

            
                List<UserBookShelfBean> booksInCartBean = new ArrayList<UserBookShelfBean>();
                booksInCartBean = ActionHelper.cartDetailsTransferServiceToAction(booksInCartVO, booksInCartBean);

                List<BooksBean> booksInCartList = ActionHelper.booksInCartList(booksInCartBean);

               
                request.setAttribute("booksInCartList", booksInCartList);

            LOGGER.info("LIST RECIEVED..");
            return SUCCESS;

        } 
        catch (ServiceException e)
        {
            return ActionConstants.FAILURE;
        }
        catch (Exception e)
        {
            LOGGER.error("EXCEPTION IN ACTION" + e);
            return ActionConstants.FAILURE;
        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public UserBookShelfBean getModel() {
        // TODO Auto-generated method stub
        return userBookShelfBean;
    }

}
