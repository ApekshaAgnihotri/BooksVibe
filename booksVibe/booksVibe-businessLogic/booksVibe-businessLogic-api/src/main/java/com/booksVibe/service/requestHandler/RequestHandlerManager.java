package com.booksVibe.service.requestHandler;

import java.util.List;

import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Interface RequestHandlerManager.
 */
public interface RequestHandlerManager {

    /**
     * View requested books.
     *
     * @param operator the operator
     * @return the list
     * @throws ServiceException             the service exception
     */
    List<RequestBookVO> viewRequestedBooks(UserValueObject operator) throws ServiceException;

    /**
     * View books to be returned.
     *
     * @param operator the operator
     * @return the list
     * @throws ServiceException             the service exception
     */
    List<RequestBookVO> viewBooksToBeReturned(UserValueObject operator) throws ServiceException;

    
    
    /**
     * View approved requests.
     *
     * @param operator the operator
     * @return the list
     * @throws ServiceException the service exception
     */
    List<RequestBookVO> viewApprovedRequests(UserValueObject operator) throws ServiceException;
    
    
    /**
     * View closed returned.
     *
     * @param operator the operator
     * @return the list
     * @throws ServiceException the service exception
     */
    List<RequestBookVO> viewClosedRequests(UserValueObject operator) throws ServiceException;
    /**
     * Approve deleivery request.
     * 
     * @param requestId
     *            the request id
     * @throws ServiceException
     *             the service exception
     */
    void approveDeleiveryRequest(int requestId) throws ServiceException;

    /**
     * Close return request.
     * 
     * @param requestId
     *            the request id
     * @throws ServiceException
     *             the service exception
     */
    void closeReturnRequest(int requestId) throws ServiceException;

    /**
     * View users.
     * 
     * @return the list
     * @throws ServiceException
     *             the service exception
     */
    List<UserSubsVO> viewUsers() throws ServiceException;
    
    
    /**
     * View today's requested books.
     *
     * @param operator the operator
     * @return the list
     * @throws ServiceException the service exception
     */
    List<RequestBookVO> viewTodaysRequestedBooks(UserValueObject operator) throws ServiceException;
    
    /**
     * View today's books to be returned.
     *
     * @param operator the operator
     * @return the list
     * @throws ServiceException the service exception
     */
    List<RequestBookVO> viewTodaysBooksToBeReturned(UserValueObject operator) throws ServiceException;


}
