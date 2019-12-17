package com.booksVibe.serviceImpl.registration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.registration.RegManagerDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.registration.RegistrationManager;
import com.booksVibe.service.valueObject.SubsDetailsVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.booksVibe.serviceImpl.serviceHelper.ServiceHelper;
import com.booksVibe.util.encryption.EncryptPassword;
import com.booksVibe.util.exception.UtilException;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrationManagerImpl.
 */
public class RegistrationManagerImpl implements RegistrationManager {

    /** The user dto. */
    @Autowired
    private UserDTO userDTO;

    /** The reg manager dao */
    @Autowired
    private RegManagerDao regManagerDaoImpl;

   
   

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.registration.RegistrationManager#registerUser(com
     * .booksVibe.service.valueObject.UserValueObject)
     */
    public boolean registerUser(UserValueObject userValueObject)
            throws ServiceException {
        // TODO Auto-generated method stub

        try {
            userValueObject.setPassword(EncryptPassword.md5(userValueObject.getPassword()));
            userDTO = ServiceHelper.serviceToDaoTransfer(userValueObject,
                    userDTO);
            
            boolean status = regManagerDaoImpl.registerUser(userDTO);

            return status;

        }
        catch(UtilException e){
            throw new ServiceException(e);
        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.registration.RegistrationManager#loadSubscription()
     */
    public List<SubsDetailsVO> loadSubscription() throws ServiceException {
        try {

            List<SubsDetailsDTO> subsList = regManagerDaoImpl.loadSubscription();

            List<SubsDetailsVO> subsListVO = new ArrayList<SubsDetailsVO>();
            Iterator<SubsDetailsDTO> it = subsList.iterator();

            while (it.hasNext()) {

                SubsDetailsVO subsDetailsVO = new SubsDetailsVO();
                SubsDetailsDTO subsDetailsDTO = (SubsDetailsDTO) it.next();
                SubsDetailsVO subsDetailVO = ServiceHelper.subsDetailsTransfer(subsDetailsDTO, subsDetailsVO);
                subsListVO.add(subsDetailVO);
                
            }

            return subsListVO;
        }  catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.registration.RegistrationManager#checkStatus(java
     * .lang.String)
     */
    public boolean checkStatus(String emaild) throws ServiceException {
        try {

            boolean status = regManagerDaoImpl.checkStatus(emaild);

            return status;
        }  catch(DaoException e){
            throw new ServiceException(e);
        }

    }

}
