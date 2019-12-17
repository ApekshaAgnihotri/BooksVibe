package com.booksVibe.dao.login;

import java.util.List;

import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;

import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.exceptions.InvalidUserException;



// TODO: Auto-generated Javadoc
/**
 * The Interface LoginManagerDao.
 */
public interface LoginManagerDao {

    /**
     * Login verify.
     * 
     * @param userDTO
     *            the user dto
     * @return the user dto
     * @throws DaoException
     *             the dao exception
     * @throws InvalidUserException
     *             the invalid user exception
     * @throws SubscriptionPlanExpiredExceptionTest
     *             the subscription plan expired exception
     */
    UserDTO loginVerify(UserDTO userDTO) throws DaoException,
            InvalidUserException;

    /**
     * Update user details.
     * 
     * @param userDTO
     *            the user dto
     * @throws DaoException
     *             the dao exception
     */
    void updateUserDetails(UserDTO userDTO) throws DaoException;

    /**
     * Upgrade plan.
     * 
     * @param userDTO
     *            the user dto
     * @param subsId
     *            the subs id
     * @throws DaoException
     *             the dao exception
     */
    void upgradePlan(UserDTO userDTO, int subsId) throws DaoException;

    /**
     * View subscription history.
     * 
     * @param userDTO
     *            the user dto
     * @return the list
     * @throws DaoException
     *             the dao exception
     */
    List<UserSubsDTO> viewSubscriptionHistory(UserDTO userDTO)
            throws DaoException;
}
