package com.booksVibe.serviceImpl.webService;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.InvalidUserException;
import com.booksVibe.dao.login.LoginManagerDao;
import com.booksVibe.dao.registration.RegManagerDao;
import com.booksVibe.util.encryption.EncryptPassword;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthenticateOperatorServiceImpl.
 */
@Path("/OperatorAuthenticationService")
public class AuthenticateOperatorServiceImpl {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(AuthenticateOperatorServiceImpl.class);

    /** The user dto. */
    @Autowired
    private UserDTO userDTO;

    /** The reg manager dao impl. */
    @Autowired
    private RegManagerDao regManagerDaoImpl;
    
    @Autowired
    private LoginManagerDao loginManagerDao;

 
    
    
    /**
     * Register operator.
     * 
     * @param emaild
     *            the emaild
     * @param password
     *            the password
     * @return the string
     */
    @POST
    @Path("/registerOperator")
    @Produces(MediaType.TEXT_XML)
    public String registerOperator(@FormParam("emaild") String emaild,
            @FormParam("password") String password,
            @FormParam("firstname") String firstName,
            @FormParam("lastname") String lastName,
            @FormParam("operatorEmaild") String operatorEmaild,
            @FormParam("operatorPassword")String operatorPassword)

    {
        try {
            userDTO.setEmaild(operatorEmaild);
            userDTO.setPassword(EncryptPassword.md5(operatorPassword));
            userDTO.setRole("master");
            UserDTO operator=loginManagerDao.loginVerify(userDTO);
            if(operator!=null){
                userDTO.setEmaild(emaild);
                userDTO.setPassword(EncryptPassword.md5(password));
                userDTO.setFirstname(firstName);
                userDTO.setLastname(lastName);
                
                boolean status = regManagerDaoImpl.registerOperator(userDTO);

                if (status) {
                    return  "<RegisterOperator>"
                            + "<Message> User Registered Successfully </Message>"
                            + "</RegisterOperator>";
                           
                } else {
                    return "<RegisterOperator>"
                            + "<Message>Email Id already exists!!</Message>"
                            + "</RegisterOperator>";
                }

                
            }
           /*this return is never executed*/
             return null; 
            
        
            
        } 
        catch(InvalidUserException e){
            return "<Operator>"
                    + "<Message>Master Authentication Failed</Message>"
                    + "</Operator>";
        }
        
        catch (Exception e) {
            LOGGER.error("EXCEPTION" + e);
            return "<RegisterOperator>"
                    + "<Message>Something went wrong!!</Message>"
                    + "</RegisterOperator>";
        }

    }

}