package com.booksVibe.interceptors;

import java.util.Map;

import org.apache.log4j.Logger;

import com.booksVibe.models.UserBean;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminInterceptor.
 */
public class AdminInterceptor implements Interceptor {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(AdminInterceptor.class);

    /** The Constant INVALID_USER_ACCESS. */
    private static final String ACCESS_DENIED = "invalidAccess",
            INVALID_USER_ACCESS = "invalidUserAccess";

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork2.interceptor.Interceptor#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork2.interceptor.Interceptor#init()
     */
    public void init() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony
     * .xwork2.ActionInvocation)
     */
    public String intercept(ActionInvocation invocation) {
        // TODO Auto-generated method stub

        LOGGER.info("OPERATOR INTERCEPTOR");
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        
        
        if (!session.containsKey("loggedUser")) 
        {
            LOGGER.info("INVALIED USER");

            return ACCESS_DENIED;
        }
        else
        {
            UserBean user = (UserBean) session.get("loggedUser");
           
            if (user.getEmaild().equalsIgnoreCase("")) {
                LOGGER.info("INVALID ACCESS\"" + user.getFirstname() + "\"");

                return ACCESS_DENIED;
            }

            if (user.getRole().equals("user")) {
                LOGGER.info("ATTEMPTING ADMIN RESOURCES");
                return INVALID_USER_ACCESS;
            }
            if (user.getRole().equals("master")) {
                LOGGER.info("ATTEMPTING SLAVES'S RESOURCES");
                return INVALID_USER_ACCESS;
            }

            LOGGER.info("OPERAOR AUTHORIZATION SUCCESSFULL");
            try {
                invocation.invoke();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                
            }
        }

        /* This return will be never invoked */
        return "";
    }

}
