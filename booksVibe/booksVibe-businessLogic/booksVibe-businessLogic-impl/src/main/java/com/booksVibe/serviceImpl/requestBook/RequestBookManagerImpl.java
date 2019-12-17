package com.booksVibe.serviceImpl.requestBook;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.requestBook.RequestBookManagerDao;
import com.booksVibe.service.exceptions.BookAlreadyRequestedException;
import com.booksVibe.service.exceptions.RequestNotAllowedException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.exceptions.SubscriptionPlanExpiredServiceException;
import com.booksVibe.service.requestBook.RequestBookManager;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.booksVibe.serviceImpl.serviceHelper.ServiceHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestBookManagerImpl.
 */
public class RequestBookManagerImpl implements RequestBookManager {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(RequestBookManagerImpl.class);

    /** The request book manager dao. */
    @Autowired
    private RequestBookManagerDao requestBookManagerDao;

    /** The request dto. */
    @Autowired
    private RequestBookDTO requestDTO;

    /**
     * (non-Javadoc).
     *
     * @param requestVO the request vo
     * @throws ServiceException the service exception
     * @throws BookAlreadyRequestedException the book already requested exception
     * @throws RequestNotAllowedException the request not allowed exception
     * @throws SubscriptionPlanExpiredServiceException the subscription plan expired service exception
     * @see com.booksVibe.service.requestBook.RequestBookManager#requestBook(com.
     * booksVibe.service.valueObject.RequestBookVO)
     */
    public void requestBook(RequestBookVO requestVO) throws ServiceException,BookAlreadyRequestedException, RequestNotAllowedException,SubscriptionPlanExpiredServiceException 
    {
        // TODO Auto-generated method stub

       try {

               requestDTO = ServiceHelper.requestTransferServiceToDao(requestVO,requestDTO);
               
               LOGGER.info("uSER ID:************"+requestDTO.getUserDTO().getEmaild()); 
               boolean status= requestBookManagerDao.checkIfPlanIsActive(requestDTO);
            

               if(status)
               {
                  LOGGER.info("PLAN IS ACTIVE");
               
                  UserSubsDTO userSubsDTO = requestBookManagerDao.getSubscribedPlan(requestDTO);
                  int maxBooks = userSubsDTO.getMaxBooks();
                  LOGGER.info("MAXbOOKS COUNT"+maxBooks);
                  int heldBook = requestBookManagerDao.countHoldingBooks(requestDTO);
                  LOGGER.info("COUNT HELD BOOK:" + heldBook);

                  int requestedBooks = requestBookManagerDao.countRequestedBooks(requestDTO);
                   LOGGER.info("COUNT REQUESTED BOOK:" + requestedBooks);

                  int totalCount = heldBook + requestedBooks;
                  LOGGER.info("TOTAL COUNT:" + totalCount);

                   if (totalCount<maxBooks)
                   {
                       LOGGER.info("TOTAL COUNT LESS THAN MAX BOOKS");
                       Boolean alreadyRequested = requestBookManagerDao.ifAlreadyRequested(requestDTO);
                    
                       if (!alreadyRequested)
                       {
                          LOGGER.info("BOOK ALREADY NOT REQUESTED");

                           requestBookManagerDao.requestBook(requestDTO);
                           
                           int bookId = requestDTO.getBooksDTO().getBookId();
                           BooksDTO booksDTO = requestBookManagerDao.getBookDetailsById(bookId);
                           
                           int copies = booksDTO.getCopies();
                           copies = copies - 1;
                           booksDTO.setCopies(copies);
                           requestBookManagerDao.updateBookCopies(booksDTO);

                       }
                       else 
                       {
                        throw new BookAlreadyRequestedException();
                       }
                  }
                   else
                   {
                    throw new RequestNotAllowedException();
                   }

            }
            else
            {
                throw new SubscriptionPlanExpiredServiceException();
            }

       }
       catch (DaoException e) 
       {
            LOGGER.error("EXCEPTION IN SERVICE LAYER");
            throw new ServiceException(e);
        }

    }

    /**
     * (non-Javadoc).
     *
     * @param requestVO the request vo
     * @return the list
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestBook.RequestBookManager#viewRequestedBooks
     * (com.booksVibe.service.valueObject.RequestBookVO)
     */
    public List<RequestBookVO> viewRequestedBooks(RequestBookVO requestVO)
            throws ServiceException {
        // TODO Auto-generated method stub
        try {
            requestDTO = ServiceHelper.requestTransferServiceToDao(requestVO,requestDTO);
            
            LOGGER.info("IN SERVICE:");
            
            List<RequestBookDTO> requestedBooksListDTO = new ArrayList<RequestBookDTO>();
            requestedBooksListDTO=requestBookManagerDao.viewRequestedBooks(requestDTO);

               
            List<RequestBookVO> requestedBooksListVO = new ArrayList<RequestBookVO>();

            requestedBooksListVO = ServiceHelper.requestedBooksListTransferServiceToDao(requestedBooksListVO,requestedBooksListDTO);

            return requestedBooksListVO;

        } catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    /**
     * (non-Javadoc).
     *
     * @param requestVO the request vo
     * @return the list
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestBook.RequestBookManager#viewIssuedBooks(
     * com.booksVibe.service.valueObject.RequestBookVO)
     */
    public List<RequestBookVO> viewIssuedBooks(RequestBookVO requestVO)
            throws ServiceException {
        // TODO Auto-generated method stub
        try {
            requestDTO = ServiceHelper.requestTransferServiceToDao(requestVO,
                    requestDTO);
            LOGGER.info("IN SERVICE:");
            List<RequestBookDTO> issuedBooksListDTO = requestBookManagerDao
                    .viewIssuedBooks(requestDTO);

            List<RequestBookVO> issuedBooksListVO = new ArrayList<RequestBookVO>();

            issuedBooksListVO = ServiceHelper
                    .requestedBooksListTransferServiceToDao(issuedBooksListVO,
                            issuedBooksListDTO);

            return issuedBooksListVO;

        } catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    /**
     * (non-Javadoc).
     *
     * @param requestVO the request vo
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestBook.RequestBookManager#cancelDeleiveryRequest
     * (com.booksVibe.service.valueObject.RequestBookVO)
     */
    public void cancelDeleiveryRequest(RequestBookVO requestVO)
            throws ServiceException {
        try {
            requestDTO = ServiceHelper.requestTransferServiceToDao(requestVO,
                    requestDTO);
            requestBookManagerDao.cancelDeleiveryRequest(requestDTO);
            int bookId = requestDTO.getBooksDTO().getBookId();

            BooksDTO booksDTO = requestBookManagerDao.getBookDetailsById(bookId);

            int copies = booksDTO.getCopies();
            copies = copies + 1;
            booksDTO.setCopies(copies);

            requestBookManagerDao.updateBookCopies(booksDTO);

            LOGGER.info("NO OF COPIES UPDATED");
        }  catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    /**
     * (non-Javadoc).
     *
     * @param requestVO the request vo
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestBook.RequestBookManager#bookReturnRequest
     * (com.booksVibe.service.valueObject.RequestBookVO)
     */
    public void bookReturnRequest(RequestBookVO requestVO)
            throws ServiceException {
        try {

            requestDTO = ServiceHelper.requestTransferServiceToDao(requestVO,
                    requestDTO);

            requestBookManagerDao.bookReturnRequest(requestDTO);

        } catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    /**
     * (non-Javadoc).
     *
     * @param requestVO the request vo
     * @return the list
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestBook.RequestBookManager#viewToBeReturnedBooks
     * (com.booksVibe.service.valueObject.RequestBookVO)
     */
    public List<RequestBookVO> viewToBeReturnedBooks(RequestBookVO requestVO)
            throws ServiceException {
        // TODO Auto-generated method stub

        try {

            requestDTO = ServiceHelper.requestTransferServiceToDao(requestVO,
                    requestDTO);
            LOGGER.info("IN SERVICE:");
            List<RequestBookDTO> toBeReturnedBooksListDTO = requestBookManagerDao.viewToBeReturnedBooks(requestDTO);

            List<RequestBookVO> toBeReturnedBooksListVO = new ArrayList<RequestBookVO>();

            toBeReturnedBooksListVO = ServiceHelper
                    .requestedBooksListTransferServiceToDao(
                            toBeReturnedBooksListVO, toBeReturnedBooksListDTO);

            return toBeReturnedBooksListVO;

        }  catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    /**
     * (non-Javadoc).
     *
     * @param requestVO the request vo
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestBook.RequestBookManager#cancelReturnRequest
     * (com.booksVibe.service.valueObject.RequestBookVO)
     */
    public void cancelReturnRequest(RequestBookVO requestVO)
            throws ServiceException {
        try {

            requestDTO = ServiceHelper.requestTransferServiceToDao(requestVO,
                    requestDTO);

            requestBookManagerDao.cancelReturnRequest(requestDTO);

        }  catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    /**
     * (non-Javadoc).
     *
     * @param requestVO the request vo
     * @return the list
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.requestBook.RequestBookManager#viewMyHistory(com
     * .booksVibe.service.valueObject.RequestBookVO)
     */
    public List<RequestBookVO> viewMyHistory(RequestBookVO requestVO)
            throws ServiceException {
        try {

            requestDTO = ServiceHelper.requestTransferServiceToDao(requestVO,
                    requestDTO);

            List<RequestBookDTO> myHistoryListDTO = requestBookManagerDao
                    .viewMyHistory(requestDTO);

            List<RequestBookVO> myHistoryListVO = new ArrayList<RequestBookVO>();
            myHistoryListVO = ServiceHelper
                    .requestedBooksListTransferServiceToDao(myHistoryListVO,
                            myHistoryListDTO);

            LOGGER.info("LIST RECEIVED FROM DAO" + myHistoryListVO.size());

            return myHistoryListVO;

        }  catch(DaoException e){
            throw new ServiceException(e);
        }
    }
    
    
    
    /** (non-Javadoc)
     * @see com.booksVibe.service.requestBook.RequestBookManager#viewMyPlan(com.booksVibe.service.valueObject.UserValueObject)
     */
    public UserSubsVO viewMyPlan(UserValueObject userValueObject) throws ServiceException{
        try{
            LOGGER.info("REQUESTING IN SERVICE");
            UserDTO userDTO=new UserDTO();
            userDTO=ServiceHelper.serviceToDaoTransfer(userValueObject, userDTO);
            requestDTO.setUserDTO(userDTO);
            UserSubsDTO userSubsDTO=requestBookManagerDao.getSubscribedPlan(requestDTO);
            LOGGER.info("PLAN RECEIVED:"+userSubsDTO.getSubsName());
            UserSubsVO userSubsVO=new UserSubsVO();
            userSubsVO=ServiceHelper.userSubsPlanDetailsTransfer(userSubsVO, userSubsDTO);
            return userSubsVO;
        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
    }

}
