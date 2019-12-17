package com.booksVibe.service.requestBook;

import java.util.List;

import com.booksVibe.service.exceptions.BookAlreadyRequestedException;
import com.booksVibe.service.exceptions.RequestNotAllowedException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.exceptions.SubscriptionPlanExpiredServiceException;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Interface RequestBookManager.
 */
public interface RequestBookManager {

    /**
     * Request book.
     * 
     * @param requestVO
     *            the request vo
     * @throws ServiceException
     *             the service exception
     * @throws BookAlreadyRequestedException
     *             the book already requested exception
     * @throws RequestNotAllowedException
     *             the request not allowed exception
     * @throws SubscriptionPlanExpiredServiceException
     *             the subscription plan expired service exception
     */
    void requestBook(RequestBookVO requestVO) throws ServiceException,
            BookAlreadyRequestedException, RequestNotAllowedException,
            SubscriptionPlanExpiredServiceException;

    /**
     * View requested books.
     * 
     * @param requestVO
     *            the request vo
     * @return the list
     * @throws ServiceException
     *             the service exception
     */
    List<RequestBookVO> viewRequestedBooks(RequestBookVO requestVO)
            throws ServiceException;

    /**
     * View issued books.
     * 
     * @param requestVO
     *            the request vo
     * @return the list
     * @throws ServiceException
     *             the service exception
     */
    List<RequestBookVO> viewIssuedBooks(RequestBookVO requestVO)
            throws ServiceException;

    /**
     * Cancel deleivery request.
     * 
     * @param requestVO
     *            the request vo
     * @throws ServiceException
     *             the service exception
     */
    void cancelDeleiveryRequest(RequestBookVO requestVO)
            throws ServiceException;

    /**
     * Book return request.
     * 
     * @param requestVO
     *            the request vo
     * @throws ServiceException
     *             the service exception
     */
    void bookReturnRequest(RequestBookVO requestVO) throws ServiceException;

    /**
     * View to be returned books.
     * 
     * @param requestVO
     *            the request vo
     * @return the list
     * @throws ServiceException
     *             the service exception
     */
    List<RequestBookVO> viewToBeReturnedBooks(RequestBookVO requestVO)
            throws ServiceException;

    /**
     * Cancel return request.
     * 
     * @param requestVO
     *            the request vo
     * @throws ServiceException
     *             the service exception
     */
    void cancelReturnRequest(RequestBookVO requestVO) throws ServiceException;

    /**
     * View my history.
     * 
     * @param requestVO
     *            the request vo
     * @return the list
     * @throws ServiceException
     *             the service exception
     */
    List<RequestBookVO> viewMyHistory(RequestBookVO requestVO)
            throws ServiceException;
    
   UserSubsVO viewMyPlan(UserValueObject userValueObject) throws ServiceException;
}
