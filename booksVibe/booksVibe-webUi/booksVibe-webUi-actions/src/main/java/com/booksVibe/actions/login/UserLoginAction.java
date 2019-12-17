package com.booksVibe.actions.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.actions.constants.ActionConstants;
import com.booksVibe.actions.helper.ActionHelper;
import com.booksVibe.models.UserBean;
import com.booksVibe.models.UserSubsBean;
import com.booksVibe.service.books.BooksManager;
import com.booksVibe.service.exceptions.InvalidUserServiceExcpetion;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.login.LoginManager;
import com.booksVibe.service.registration.RegistrationManager;
import com.booksVibe.service.requestHandler.RequestHandlerManager;
import com.booksVibe.service.valueObject.ListCarrierVO;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.SubsDetailsVO;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class UserLoginAction.
 * This class contains method related to user login.
 * 
 *  */
public class UserLoginAction extends ActionSupport implements
        ModelDriven<UserBean> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(UserLoginAction.class);

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The request. */
    private HttpServletRequest request = ServletActionContext.getRequest();

    /** The session. */
    private HttpSession session = request.getSession();

    /** The user value object. */
    @Autowired
    private UserValueObject userValueObject;

    /** The login manager impl. */
    @Autowired
    private LoginManager loginManagerImpl;

    /** The user bean. */
    @Autowired
    private UserBean userBean;
    
    /** The request handler manager. */
    @Autowired
    private RequestHandlerManager requestHandlerManager;
    
    /** The registration manager. */
    @Autowired
    private RegistrationManager registrationManager;

    /** The books manager. */
    @Autowired
    private BooksManager booksManager;
    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public UserBean getModel() {
        return userBean;
    }

    /**
     * Login verify.
     * This method verifies users login credentials and 
     * returns appropriate messages.
     * @return the string
     */
    public String loginVerify() 
    {
     try {
            LOGGER.info("VERIFYING IN ACTION..");
            userValueObject.setEmaild(userBean.getEmaild());
            userValueObject.setPassword(userBean.getPassword());
            userValueObject.setRole(userBean.getRole());

            UserValueObject loginValueObject = loginManagerImpl.loginVerify(userValueObject);

            if (loginValueObject != null)
            {
                LOGGER.info("USER VERIFIED");

                    userBean = ActionHelper.objectTransfer(userBean,loginValueObject);

                    session.setAttribute("loggedUser", userBean);
                    LOGGER.info("SESSION CREATED");

                    return userHomePage();
            }
        } 
        catch (InvalidUserServiceExcpetion ie) {
            addActionError(getText("Invalid.User"));
            LOGGER.error("INVALID USERNAME AND PASSWORD");
        }
        catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } 
        catch (Exception e) {
            LOGGER.error("EXCEPTION IN ACTION" + e);
            return ActionConstants.FAILURE;
        }

        return ERROR; 

    }

    
    
    /**
     * Logout.
     * This method perform user logout action.
     * @return the string
     */
    @SkipValidation
    public String logout() 
    {
        LOGGER.info("USER SUCESSFULLY LOGGED OUT)");
        addActionMessage(getText("LogoutSuccessfully"));
        session.removeAttribute("loggedUser");
        session.invalidate();
        return ActionConstants.LOGOUT;
    }

    /**
     * Gets the user profile .
     * This method returns user profile page
     * @return the user profile form
     */
    @SkipValidation
    public String getUserProfileForm() 
    {
        return SUCCESS;

    }

    /**
     * Update user details.
     * This method updates user's details.
     * @return the string
     */
    public String updateUserDetails()
    {

      try {

            userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);

            loginManagerImpl.updateUserDetails(userValueObject);
            
            return SUCCESS;

        } 
        catch (ServiceException e) 
        {
            return ActionConstants.FAILURE;
        }
        catch (Exception e) 
        {
            LOGGER.error("updateuserDetails exception" + e);
            return ActionConstants.FAILURE;
        }

    }

    /**
     * Edits the user details.
     * This method returns user's edit profile page.
     * @return the string
     */
    public String editUserDetailsPage() 
    {
        return SUCCESS;
    }

    /**
     * Gets the login page.
     * 
     * @return the index page
     */
    public String getLoginPage()
    {
        return SUCCESS;
    }

    
    /**
     * Gets the index page.
     *
     * @return the index page
     */
    public String getIndexPage()
    {
        return SUCCESS;
    }

    
    
    /**
     * Upgrade plan.
     * This method upgrades user's plan once the previous plan is expired.
     * @return the string
     */
    public String upgradePlan()
    {
       try {

            LOGGER.info("UPGRADATION IN ACTION");

            userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute("userBean");

            int subsId = Integer.parseInt(ServletActionContext.getRequest().getParameter("subsid"));

            userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);

            loginManagerImpl.upgradePlan(userValueObject, subsId);

            addActionMessage(getText("PlanUpdated"));
            return SUCCESS;

        } 
        catch (ServiceException e)
        {
            return ActionConstants.FAILURE;
        } 
       catch (Exception e)
       {
            LOGGER.error("EXCEPTION IN UPDATING PLAN" + e);
            return ERROR;
        }

    }

    /**
     * View subscription history.
     * This method fetches user's subscription plan history
     * @return the string
     */
    public String viewSubscriptionHistory()
    {
      try {
            LOGGER.info("REQUESTING IN ACTION");

             userBean = (UserBean) ServletActionContext.getRequest()
                    .getSession().getAttribute("userBean");
            userValueObject = ActionHelper.actionToServiceTransfer(userBean,
                    userValueObject);

            List<UserSubsVO> planListVO = loginManagerImpl
                    .viewSubscriptionHistory(userValueObject);
            List<UserSubsBean> planList = new ArrayList<UserSubsBean>();
            planList = ActionHelper.usersSubsDetailsTransfer(planListVO,
                    planList);

             request = ServletActionContext.getRequest();
            request.setAttribute("planList", planList);

            return SUCCESS;
        }
        catch (ServiceException e) 
        {
           return ActionConstants.FAILURE;
        }
        catch (Exception e)
        {
            LOGGER.error("EXCEPTION IN VIEWING SUBSCRIPTIN HISTORY " + e);
            return ActionConstants.FAILURE;
        }
    }

    
    /**
     * User home page.
     * This method returns user's home page
     * @return the string
     */
    public String userHomePage() 
    {
      try{
           userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute("userBean");
            userValueObject=ActionHelper.actionToServiceTransfer(userBean, userValueObject);
            
           if (userBean.getRole().equals("master")) 
           {           
                LOGGER.info("LOGGED IN AS MASTER ADMIN");
           
                List<RequestBookVO> toBeReturnedBooksList=requestHandlerManager.viewBooksToBeReturned(userValueObject);
                List<RequestBookVO> requestedBooksList=requestHandlerManager.viewRequestedBooks(userValueObject);
                List<RequestBookVO> approvedRequestsList=requestHandlerManager.viewApprovedRequests(userValueObject);
                List<RequestBookVO> closedRequestsList=requestHandlerManager.viewClosedRequests(userValueObject);
                List<UserSubsVO> activeUsersList = requestHandlerManager.viewUsers();
                List<SubsDetailsVO> activeSubsList=registrationManager.loadSubscription();
                List<RequestBookVO> todaysToBeReturnedBooksList=requestHandlerManager.viewTodaysBooksToBeReturned(userValueObject);
                List<RequestBookVO> todaysRequestedBooksList=requestHandlerManager.viewTodaysRequestedBooks(userValueObject);
                ListCarrierVO listCarrierVO=booksManager.loadBooksDetails(0,userValueObject);
           
                request.setAttribute("totalBooks", listCarrierVO.getTotalRecords());
                request.setAttribute("returnRequests",toBeReturnedBooksList.size());
                request.setAttribute("deliveryRequests",requestedBooksList.size());
                request.setAttribute("todaysReturnRequests",todaysToBeReturnedBooksList.size());
                request.setAttribute("todaysDeliveryRequests",todaysRequestedBooksList.size());
                request.setAttribute("approvedRequests",approvedRequestsList.size());
                request.setAttribute("closedRequests",closedRequestsList.size());
                request.setAttribute("activeUsers",activeUsersList.size());
                request.setAttribute("activePlans",activeSubsList.size());
                request.setAttribute("totalRequests",toBeReturnedBooksList.size()+requestedBooksList.size());
                
           return ActionConstants.ADMIN_PAGE;
       }
       else if (userBean.getRole().equalsIgnoreCase("admin")) 
       {
           LOGGER.info("LOGIN AS SLAVE ADMIN");
           
               List<RequestBookVO> toBeReturnedBooksList=requestHandlerManager.viewBooksToBeReturned(userValueObject);
               List<RequestBookVO> requestedBooksList=requestHandlerManager.viewRequestedBooks(userValueObject);
               List<RequestBookVO> approvedRequestsList=requestHandlerManager.viewApprovedRequests(userValueObject);
               List<RequestBookVO> closedRequestsList=requestHandlerManager.viewClosedRequests(userValueObject);
               List<RequestBookVO> todaysToBeReturnedBooksList=requestHandlerManager.viewTodaysBooksToBeReturned(userValueObject);
               List<RequestBookVO> todaysRequestedBooksList=requestHandlerManager.viewTodaysRequestedBooks(userValueObject);
           
               request.setAttribute("returnRequests",toBeReturnedBooksList.size());
               request.setAttribute("deliveryRequests",requestedBooksList.size());
               request.setAttribute("approvedRequests",approvedRequestsList.size());
               request.setAttribute("closedRequests",closedRequestsList.size());
               request.setAttribute("todaysReturnRequests",todaysToBeReturnedBooksList.size());
               request.setAttribute("todaysDeliveryRequests",todaysRequestedBooksList.size());
           return ActionConstants.SLAVE_ADMIN_PAGE;
       }
       else 
       {
           return SUCCESS;
       }
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
