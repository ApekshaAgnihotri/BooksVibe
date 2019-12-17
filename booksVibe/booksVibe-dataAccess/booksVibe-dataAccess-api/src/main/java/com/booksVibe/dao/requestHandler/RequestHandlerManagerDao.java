package com.booksVibe.dao.requestHandler;

import java.util.List;

import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface RequestHandlerManagerDao.
 */
public interface RequestHandlerManagerDao {

    /**
     * View requested books.
     *
     * @param operator the operator
     * @return the list
     * @throws DaoException             the dao exception
     */
    List<RequestBookDTO> viewRequestedBooks(UserDTO operator) throws DaoException;

    /**
     * View books to be returned.
     *
     * @param operator the operator
     * @return the list
     * @throws DaoException             the dao exception
     */
    List<RequestBookDTO> viewBooksToBeReturned(UserDTO operator) throws DaoException;

    
    /**
     * View approved requests.
     *
     * @param operator the operator
     * @return the list
     * @throws DaoException the dao exception
     */
    List<RequestBookDTO> viewApprovedRequests(UserDTO operator) throws DaoException;
    
    /**
     * View closed requests.
     *
     * @param operator the operator
     * @return the list
     * @throws DaoException the dao exception
     */
    List<RequestBookDTO> viewClosedRequests(UserDTO operator) throws DaoException;
    
    /**
     * View todays requested books.
     *
     * @param operator the operator
     * @return the list
     * @throws DaoException the dao exception
     */
    List<RequestBookDTO> viewTodaysRequestedBooks(UserDTO operator) throws DaoException;
    
    /**
     * View todays books to be returned.
     *
     * @param operator the operator
     * @return the list
     * @throws DaoException the dao exception
     */
    List<RequestBookDTO> viewTodaysBooksToBeReturned(UserDTO operator) throws DaoException;
    
    
    /**
     * Approve deleivery request.
     * 
     * @param requestId
     *            the request id
     * @throws DaoException
     *             the dao exception
     */
    void approveDeleiveryRequest(int requestId) throws DaoException;

    /**
     * Close return request.
     * 
     * @param requestId
     *            the request id
     * @throws DaoException
     *             the dao exception
     */
    void closeReturnRequest(int requestId) throws DaoException;

    /**
     * View users.
     * 
     * @return the list
     * @throws DaoException
     *             the dao exception
     */
    List<UserSubsDTO> viewUsers() throws DaoException;
}
