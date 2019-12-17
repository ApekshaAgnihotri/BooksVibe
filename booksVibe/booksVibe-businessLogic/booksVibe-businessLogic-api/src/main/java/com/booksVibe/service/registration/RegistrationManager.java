package com.booksVibe.service.registration;

import java.util.List;

import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.SubsDetailsVO;
import com.booksVibe.service.valueObject.UserValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Interface RegistrationManager.
 */
public interface RegistrationManager {

    /**
     * Register user.
     * 
     * @param userValueObject
     *            the user value object
     * @return true, if successful
     * @throws ServiceException
     *             the service exception
     */
    boolean registerUser(UserValueObject userValueObject)
            throws ServiceException;

    /**
     * Load subscription.
     * 
     * @return the list
     * @throws ServiceException
     *             the service exception
     */
    List<SubsDetailsVO> loadSubscription() throws ServiceException;

    /**
     * Check status.
     * 
     * @param emaild
     *            the emaild
     * @return true, if successful
     * @throws ServiceException
     *             the service exception
     */
    boolean checkStatus(String emaild) throws ServiceException;

}
