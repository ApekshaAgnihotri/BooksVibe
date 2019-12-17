package com.booksVibe.actions.registration;

/**
 * @author apeksha.agnihotri
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.actions.constants.ActionConstants;
import com.booksVibe.actions.helper.ActionHelper;
import com.booksVibe.models.SubsDetailsBean;
import com.booksVibe.models.UserBean;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.registration.RegistrationManager;
import com.booksVibe.service.valueObject.SubsDetailsVO;
import com.booksVibe.service.valueObject.UserValueObject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRegistrationAction.
 * */
public class UserRegistrationAction extends ActionSupport implements
        ModelDriven<UserBean> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(UserRegistrationAction.class);

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The request. */
    private HttpServletRequest request = ServletActionContext.getRequest();

    /** The session. */
    private HttpSession session = request.getSession();

    /** The user bean. */
    @Autowired
    private UserBean userBean;

    /** The user value object. */
    @Autowired
    private UserValueObject userValueObject;

    /** The registration manager. */
    @Autowired
    private RegistrationManager registrationManager;

    /** The status. */
    private Boolean status = false;

   
    /**
     * Register user.
     * This method registers a new user.
     * @return the string
     */
    public String registerUser() 
    {
     try 
     {
            LOGGER.info("REGISTERING...");
            userValueObject = ActionHelper.actionToServiceTransfer(userBean,userValueObject);

            status = registrationManager.registerUser(userValueObject);

            if (status) 
            {
                LOGGER.info("registered successfully....");
                return ActionConstants.LOGIN_PAGE;

            }
            else 
            {
                LOGGER.error("EMAIL ID ALREADY EXIST" + status);
                addActionError(getText("RegistrationFailed"));
                return ERROR;

            }

        } catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } catch (Exception e) {
            LOGGER.error("service exception in registrationaction." + e);
            return ActionConstants.FAILURE;
        }

    }

    /**
     * Load subscription plans.
     * This method fetches active subscription plans
     * @return the string
     */
    @SkipValidation
    public String loadSubscription() {
        try {
            LOGGER.info("LOADING SUBSCRIPTION PLANS");
            List<SubsDetailsVO> subsListVO = registrationManager
                    .loadSubscription();
            Iterator<SubsDetailsVO> it = subsListVO.iterator();

            List<SubsDetailsBean> subsListBean = new ArrayList<SubsDetailsBean>();

            while (it.hasNext()) {
                SubsDetailsBean subsDetailsBean = new SubsDetailsBean();
                SubsDetailsVO subsDetailsVO = (SubsDetailsVO) it.next();
                subsDetailsBean = ActionHelper.subsDetailsTransfer(subsDetailsVO, subsDetailsBean);
                subsListBean.add(subsDetailsBean);
            }
            session.setAttribute("subscriptionList", subsListBean);

            return SUCCESS;

        } catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } catch (Exception e) {

            LOGGER.error("EXCEPION IN FETCHING SUBSCRITION PLANS" + e);
            return ActionConstants.FAILURE;
        }
    }

    /**
     * View subscription plans.
     * 
     * @return the string
     */
    @SkipValidation
    public String viewSubscriptionPlans() {
        try {
            String result = loadSubscription();

            if (result.equals(SUCCESS)) {
                 userBean = (UserBean) ServletActionContext
                        .getRequest().getSession().getAttribute("userBean");
                LOGGER.info("USER ID" + userBean.getEmaild());
                 status = registrationManager.checkStatus(userBean
                        .getEmaild());

                if (status) {
                    LOGGER.info("USER IS ACTIVE");
                     request = ServletActionContext
                            .getRequest();
                    request.setAttribute("userStatus", "active");
                    return SUCCESS;
                } else {
                    LOGGER.info("USER IS INACTIVE");
                     request = ServletActionContext
                            .getRequest();
                    request.setAttribute("userStatus", "inactive");
                    return SUCCESS;
                }
            } else {
                return ERROR;
            }
        } catch (ServiceException e) {
            return ActionConstants.FAILURE;
        } catch (Exception e) {
            LOGGER.error("EXCEPTION WHILE LOADING SUBSCRIPTION PLANS");
            return ERROR;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public UserBean getModel() {

        return userBean;
    }

}
