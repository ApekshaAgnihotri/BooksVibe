package com.booksVibe.serviceImpl.login;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.exceptions.InvalidUserException;
import com.booksVibe.dao.login.LoginManagerDao;
import com.booksVibe.service.exceptions.InvalidUserServiceExcpetion;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.login.LoginManager;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.booksVibe.serviceImpl.serviceHelper.ServiceHelper;
import com.booksVibe.util.encryption.EncryptPassword;
import com.booksVibe.util.exception.UtilException;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginManagerImpl.
 */
public class LoginManagerImpl implements LoginManager {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(LoginManagerImpl.class);

    /** The user dto. */
    @Autowired
    private UserDTO userDTO;

    /** The login manager dao impl. */
    @Autowired
    private LoginManagerDao loginManagerDaoImpl;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.login.LoginManager#loginVerify(com.booksVibe.service
     * .valueObject.UserValueObject)
     */
    public UserValueObject loginVerify(UserValueObject userValueObject)
            throws ServiceException, InvalidUserServiceExcpetion {

        UserValueObject loginValueObject = null;

        try {
            
               
            userDTO.setEmaild(userValueObject.getEmaild());
            userDTO.setPassword(EncryptPassword.md5(userValueObject.getPassword()));
            userDTO.setRole(userValueObject.getRole());
            LOGGER.info("PASSING TO LOGIN DAO");
            UserDTO loginDTO = loginManagerDaoImpl.loginVerify(userDTO);

            if (loginDTO != null) {
                loginValueObject = ServiceHelper.objectTransfer(
                        userValueObject, loginDTO);
                return loginValueObject;
            }

        }

        catch(UtilException e){
            LOGGER.error("EXCEPTION IN ENCRYPTING PASSWORD"+e);
            throw new ServiceException(e);
        }
        catch (InvalidUserException e) {
            LOGGER.error("INVALID USER EXCEPTION IN SERVICE." + e);
            throw new InvalidUserServiceExcpetion("InvalidUserException: "+e);
            
        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
       
        return loginValueObject;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.login.LoginManager#updateUserDetails(com.booksVibe
     * .service.valueObject.UserValueObject)
     */
    public void updateUserDetails(UserValueObject userValueObject)
            throws ServiceException {
        try {
            LOGGER.info("UPDATING USER DETAILS IN SERVICE");

            userDTO = ServiceHelper.serviceToDaoTransfer(userValueObject,
                    userDTO);

            loginManagerDaoImpl.updateUserDetails(userDTO);

        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
       
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.login.LoginManager#upgradePlan(com.booksVibe.service
     * .valueObject.UserValueObject, int)
     */
    public void upgradePlan(UserValueObject userValueObject, int subsId)
            throws ServiceException {
        try {
            LOGGER.info("UPGRADATION IN SERVICE");

            userDTO = ServiceHelper.serviceToDaoTransfer(userValueObject,
                    userDTO);

            loginManagerDaoImpl.upgradePlan(userDTO, subsId);

        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
        
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.login.LoginManager#viewSubscriptionHistory(com.
     * booksVibe.service.valueObject.UserValueObject)
     */
    public List<UserSubsVO> viewSubscriptionHistory(
            UserValueObject userValueObject) throws ServiceException {
        try {

            userDTO = ServiceHelper.serviceToDaoTransfer(userValueObject,userDTO);
            List<UserSubsDTO> planListDTO = loginManagerDaoImpl.viewSubscriptionHistory(userDTO);
            List<UserSubsVO> planListVO = new ArrayList<UserSubsVO>();
            planListVO = ServiceHelper.usersSubsDetailsTransfer(planListDTO,planListVO);
            LOGGER.info("LIST SIZE:" + planListVO.size());
            return planListVO;
        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
        
    }

}
