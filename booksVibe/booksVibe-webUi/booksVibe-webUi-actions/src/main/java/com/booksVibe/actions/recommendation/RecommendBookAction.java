package com.booksVibe.actions.recommendation;

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
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.recommendation.RecommendBooksManager;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.opensymphony.xwork2.ActionSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class RecommendBookAction.
 * This class contains method related to display user's 
 * recommended books
 */
public class RecommendBookAction extends ActionSupport {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The recommend books manager. */
    @Autowired
    private RecommendBooksManager recommendBooksManager;

    /** The user value object. */
    @Autowired
    private UserValueObject userValueObject;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(RecommendBookAction.class);

    /**
     * Gets the recommended books.
     * This method fetches the recommended books
     * @return the recommended books
     */
    public String getRecommendedBooks() 
    {
     try{

            UserBean userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute("userBean");

            userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);

            List<BooksVO> booksListVO = recommendBooksManager.getRecommendedBooks(userValueObject);
            
            List<BooksBean> booksListBean = new ArrayList<BooksBean>();
            booksListBean = ActionHelper.booksListTransfer(booksListVO,booksListBean);

            if (booksListVO.size() > 0) 
            {
                HttpServletRequest request = ServletActionContext.getRequest();
                request.setAttribute("recommendedBooksList", booksListBean);

                return SUCCESS;
            }
            else
            {
                addActionMessage(getText("NoRecommendations"));
                return ERROR;
            }

        }
        catch (ServiceException e) 
        {
            return ActionConstants.FAILURE;
        }
        catch (Exception e)
        {
            LOGGER.error("EXCEPTION IN RECOMMEND BOOKS ACTION");
            return ActionConstants.FAILURE;
        }
    }
}
