package com.booksVibe.dao.registration;

import java.util.List;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface RegManagerDao.
 */
public interface RegManagerDao {

    /**
     * Register user.
     * 
     * @param userDTO
     *            the user dto
     * @return true, if successful
     * @throws DaoException
     *             the dao exception
     */
    boolean registerUser(UserDTO userDTO) throws DaoException;

    /**
     * Load subscription.
     * 
     * @return the list
     * @throws DaoException
     *             the dao exception
     */
    List<SubsDetailsDTO> loadSubscription() throws DaoException;

    /**
     * Check status.
     * 
     * @param emaild
     *            the emaild
     * @return true, if successful
     * @throws DaoException
     *             the dao exception
     */
    boolean checkStatus(String emaild) throws DaoException;

    /**
     * Register operator.
     * 
     * @param userDTO
     *            the user dto
     * @return true, if successful
     * @throws DaoException
     *             the dao exception
     */
    boolean registerOperator(UserDTO userDTO) throws DaoException;
}
