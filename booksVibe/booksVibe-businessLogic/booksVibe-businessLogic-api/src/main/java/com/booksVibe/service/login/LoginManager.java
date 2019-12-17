package com.booksVibe.service.login;

import java.util.List;

import com.booksVibe.service.exceptions.InvalidUserServiceExcpetion;
import com.booksVibe.service.exceptions.ServiceException;

import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoginManager.
 */
public interface LoginManager {

    /**
     * Login verify.
     * 
     * @param userValueObject
     *            the user value object
     * @return the user value object
     * @throws ServiceException
     *             the service exception
     * @throws InvalidUserServiceExcpetion
     *             the invalid user service excpetion
     * @throws SubscriptionPlanExpiredServiceException
     *             the subscription plan expired service exception
     */
    UserValueObject loginVerify(UserValueObject userValueObject)
            throws ServiceException, InvalidUserServiceExcpetion;

    /**
     * Update user details.
     * 
     * @param userValueObject
     *            the user value object
     * @throws ServiceException
     *             the service exception
     */
    void updateUserDetails(UserValueObject userValueObject)
            throws ServiceException;

    /**
     * Upgrade plan.
     * 
     * @param userValueObject
     *            the user value object
     * @param subsId
     *            the subs id
     * @throws ServiceException
     *             the service exception
     */
    void upgradePlan(UserValueObject userValueObject, int subsId)
            throws ServiceException;

    /**
     * View subscription history.
     * 
     * @param userValueObject
     *            the user value object
     * @return the list
     * @throws ServiceException
     *             the service exception
     */
    List<UserSubsVO> viewSubscriptionHistory(UserValueObject userValueObject)
            throws ServiceException;
}
