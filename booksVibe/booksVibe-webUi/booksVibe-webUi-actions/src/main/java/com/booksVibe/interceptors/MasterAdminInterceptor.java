package com.booksVibe.interceptors;

import java.util.Map;

import org.apache.log4j.Logger;

import com.booksVibe.models.UserBean;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MasterAdminInterceptor implements Interceptor {

    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER=Logger.getLogger(MasterAdminInterceptor.class);
    
    /** The Constant INVALID_USER_ACCESS. */
    private static final String ACCESS_DENIED="invalidAccess",INVALID_USER_ACCESS="invalidUserAccess";
    
    

    public void destroy() {
        // TODO Auto-generated method stub
        
    }


    public void init() {
        // TODO Auto-generated method stub
        
    }

    public String intercept(ActionInvocation invocation)  {
        // TODO Auto-generated method stub
        LOGGER.info("MASTER ADMIN INTERCEPTOR");
        Map<String, Object> session=invocation.getInvocationContext().getSession();
        if(!session.containsKey("loggedUser"))
        {
            LOGGER.info("INVALIED USER");
            
            return ACCESS_DENIED;
        }
        else
        {
              UserBean user=(UserBean)session.get("loggedUser");
                
                
                 if(user.getEmaild().equalsIgnoreCase("")) {
                     LOGGER.info("INVALID ACCESS\""+user.getFirstname()+"\"");
          
                      return ACCESS_DENIED;
                 }
                 if(user.getRole().equals("user")){
                            LOGGER.info("ATTEMPTING OPERATOR RESOURCES");
                             return INVALID_USER_ACCESS;
                  }
                 if(user.getRole().equals("admin")){
                     LOGGER.info("ATTEMPTING MASTER'S RESOURCES");
                     return INVALID_USER_ACCESS;
                 }
            
            LOGGER.info("MASTER AUTHORIZATION SUCCESSFULL");
            try {
                invocation.invoke();
            } catch (Exception e) {
                // TODO Auto-generated catch block
              
            }
        }
        
        /*This return will be never invoked*/
        return "";

    }

}
