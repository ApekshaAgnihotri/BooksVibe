package com.booksVibe.interceptors;

import java.util.Map;

import org.apache.log4j.Logger;

import com.booksVibe.models.UserBean;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class AnnonymousUserInterceptor.
 */
public class AnnonymousUserInterceptor implements Interceptor {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

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

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(AnnonymousUserInterceptor.class);

    /** The Constant INVALID_ACCESS. */
    private static final String INVALID_ACCESS = "invalidAccess";

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony
     * .xwork2.ActionInvocation)
     */
    public String intercept(ActionInvocation invocation){
        // TODO Auto-generated method stub
        LOGGER.info("ANNONYMOUS USER INERCEPTOR");
    try{
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        if (session.containsKey("userBean")) {
            UserBean user = (UserBean) session.get("userBean");
            if (user.getEmaild().equals("")) {
                LOGGER.info("USER NOT SIGNED IN");

                invocation.invoke();
            }

            return INVALID_ACCESS;
        } else {
               invocation.invoke();
        }
    }catch(Exception e){
        /*catch*/
    }
        /* This return statement will never invoke */
        return "";

    }

}
