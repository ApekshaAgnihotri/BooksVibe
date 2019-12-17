package com.booksVibe.serviceImpl.requestHandler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.requestHandler.RequestHandlerManagerDao;
import com.booksVibe.daoImpl.requestHandler.RequestHandlerManagerDaoImpl;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.requestHandler.RequestHandlerManager;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.booksVibe.serviceImpl.serviceHelper.ServiceHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestHandlerMangerImpl.
 */
public class RequestHandlerMangerImpl implements RequestHandlerManager {

    /** The request handler manager dao. */
    @Autowired
    private RequestHandlerManagerDao requestHandlerManagerDao;

    /** The operator dto. */
    @Autowired
     private UserDTO operatorDTO;
    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(RequestHandlerManagerDaoImpl.class);

    /**
     * (non-Javadoc).
     *
     * @param operator the operator
     * @return the list
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestHandler.RequestHandlerManager#viewRequestedBooks
     * ()
     */
    public List<RequestBookVO> viewRequestedBooks(UserValueObject operator) throws ServiceException {
        // TODO Auto-generated method stub
        try {

            operatorDTO=ServiceHelper.serviceToDaoTransfer(operator, operatorDTO);
            
            List<RequestBookDTO> requestedBooksListDTO = requestHandlerManagerDao.viewRequestedBooks(operatorDTO);

            List<RequestBookVO> requestedBooksListVO = new ArrayList<RequestBookVO>();

            requestedBooksListVO = ServiceHelper.requestedBooksListTransferServiceToDao(requestedBooksListVO, requestedBooksListDTO);

            return requestedBooksListVO;

        } catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    /**
     * (non-Javadoc).
     *
     * @param operator the operator
     * @return the list
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestHandler.RequestHandlerManager#
     * viewBooksToBeReturned()
     */
    public List<RequestBookVO> viewBooksToBeReturned(UserValueObject operator) throws ServiceException {
        try {

            operatorDTO=ServiceHelper.serviceToDaoTransfer(operator, operatorDTO);
            List<RequestBookDTO> booksToBeReturnedListDTO = requestHandlerManagerDao.viewBooksToBeReturned(operatorDTO);

            List<RequestBookVO> booksToBeReturnedListVO = new ArrayList<RequestBookVO>();

            booksToBeReturnedListVO = ServiceHelper
                    .requestedBooksListTransferServiceToDao(
                            booksToBeReturnedListVO, booksToBeReturnedListDTO);

            return booksToBeReturnedListVO;

        }  catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    /**
     * (non-Javadoc).
     *
     * @param requestId the request id
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestHandler.RequestHandlerManager#
     * approveDeleiveryRequest(int)
     */
    public void approveDeleiveryRequest(int requestId) throws ServiceException {
        try {

            requestHandlerManagerDao.approveDeleiveryRequest(requestId);

        } catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    /**
     * (non-Javadoc).
     *
     * @param requestId the request id
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestHandler.RequestHandlerManager#closeReturnRequest
     * (int)
     */
    public void closeReturnRequest(int requestId) throws ServiceException {
        try {
            LOGGER.info("REQUESTING IN SERVICE");

            requestHandlerManagerDao.closeReturnRequest(requestId);

        }  catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    /**
     * (non-Javadoc).
     *
     * @return the list
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestHandler.RequestHandlerManager#viewUsers()
     */
    public List<UserSubsVO> viewUsers() throws ServiceException {
        try {

            List<UserSubsDTO> usersListDTO = requestHandlerManagerDao
                    .viewUsers();

            List<UserSubsVO> usersListVO = new ArrayList<UserSubsVO>();
            usersListVO = ServiceHelper.usersSubsDetailsTransfer(usersListDTO,
                    usersListVO);

            LOGGER.info("SIZE OF LIST RECEIVED IN SERVICE:"
                    + usersListVO.size());
            return usersListVO;

        } catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    
    /** (non-Javadoc)
     * @see com.booksVibe.service.requestHandler.RequestHandlerManager#viewApprovedRequests(com.booksVibe.service.valueObject.UserValueObject)
     */
    public List<RequestBookVO> viewApprovedRequests(UserValueObject operator)
            throws ServiceException {
        try {

            operatorDTO=ServiceHelper.serviceToDaoTransfer(operator, operatorDTO);
            List<RequestBookDTO> booksToBeReturnedListDTO = requestHandlerManagerDao.viewApprovedRequests(operatorDTO);

            List<RequestBookVO> booksToBeReturnedListVO = new ArrayList<RequestBookVO>();

            booksToBeReturnedListVO = ServiceHelper.requestedBooksListTransferServiceToDao(booksToBeReturnedListVO, booksToBeReturnedListDTO);

            return booksToBeReturnedListVO;

        }  catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    /**(non-Javadoc)
     * @see com.booksVibe.service.requestHandler.RequestHandlerManager#viewClosedRequests(com.booksVibe.service.valueObject.UserValueObject)
     */
    public List<RequestBookVO> viewClosedRequests(UserValueObject operator)
            throws ServiceException {
        try {

            operatorDTO=ServiceHelper.serviceToDaoTransfer(operator, operatorDTO);
            List<RequestBookDTO> booksToBeReturnedListDTO = requestHandlerManagerDao.viewClosedRequests(operatorDTO);

            List<RequestBookVO> booksToBeReturnedListVO = new ArrayList<RequestBookVO>();

            booksToBeReturnedListVO = ServiceHelper.requestedBooksListTransferServiceToDao(booksToBeReturnedListVO, booksToBeReturnedListDTO);

            return booksToBeReturnedListVO;

        }  catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    /** (non-Javadoc)
     * @see com.booksVibe.service.requestHandler.RequestHandlerManager#viewTodaysRequestedBooks(com.booksVibe.service.valueObject.UserValueObject)
     */
    public List<RequestBookVO> viewTodaysRequestedBooks(UserValueObject operator) throws ServiceException {
        // TODO Auto-generated method stub
        try {

            operatorDTO=ServiceHelper.serviceToDaoTransfer(operator, operatorDTO);
            
            List<RequestBookDTO> requestedBooksListDTO = requestHandlerManagerDao.viewRequestedBooks(operatorDTO);

            List<RequestBookVO> requestedBooksListVO = new ArrayList<RequestBookVO>();

            requestedBooksListVO = ServiceHelper.requestedBooksListTransferServiceToDao(requestedBooksListVO, requestedBooksListDTO);

            return requestedBooksListVO;

        } catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see com.booksVibe.service.requestHandler.RequestHandlerManager#
     * viewBooksToBeReturned()
     */
    public List<RequestBookVO> viewTodaysBooksToBeReturned(UserValueObject operator) throws ServiceException {
        try {

            operatorDTO=ServiceHelper.serviceToDaoTransfer(operator, operatorDTO);
            List<RequestBookDTO> booksToBeReturnedListDTO = requestHandlerManagerDao.viewBooksToBeReturned(operatorDTO);

            List<RequestBookVO> booksToBeReturnedListVO = new ArrayList<RequestBookVO>();

            booksToBeReturnedListVO = ServiceHelper
                    .requestedBooksListTransferServiceToDao(
                            booksToBeReturnedListVO, booksToBeReturnedListDTO);

            return booksToBeReturnedListVO;

        }  catch(DaoException e){
            throw new ServiceException(e);
        }
    }
    
    
    
}
