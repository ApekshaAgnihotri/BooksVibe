package com.booksVibe.serviceImpl.books;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.ListCarrier;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.books.BooksManagerDao;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.exceptions.NoDeleteException;
import com.booksVibe.service.books.BooksManager;
import com.booksVibe.service.exceptions.NoDeleteServiceException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.ListCarrierVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.booksVibe.serviceImpl.serviceHelper.ServiceHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksManagerImpl.
 */
public class BooksManagerImpl implements BooksManager {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(BooksManagerImpl.class);

    /** The books dto. */
    @Autowired
    private BooksDTO booksDTO;

    /** The books manager dao. */
    @Autowired
    private BooksManagerDao booksManagerDao;
    
    /** The operator dto. */
    @Autowired
    private UserDTO operatorDTO;
    


    /**
     * (non-Javadoc)
     * This method adds a new book.
     * Also it returns the status if the book is added or not.
     *
     * @param booksVO the books vo
     * @param operator the operator
     * @return the boolean
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.books.BooksManager#addBooks(com.booksVibe.service
     * .valueObject.BooksVO)
     */
    public Boolean addBooks(BooksVO booksVO,UserValueObject operator) throws ServiceException 
    {
      try {

            booksDTO = ServiceHelper.booksTranfer(booksVO, booksDTO);
            operatorDTO=ServiceHelper.serviceToDaoTransfer(operator, operatorDTO);
            Boolean status = booksManagerDao.addBooks(booksDTO,operatorDTO);

            return status;

        }
        catch(DaoException e)
        {
            throw new ServiceException(e);
        }
       
    }

    /**
     * (non-Javadoc)
     * This method gets book details when its id is known.
     *
     * @param bookId the book id
     * @return the books vo
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.books.BooksManager#booksById(int)
     */
    public BooksVO booksById(int bookId) throws ServiceException 
    {
        try {

            BooksVO booksVO = new BooksVO();

            booksDTO = booksManagerDao.booksById(bookId);

            booksVO = ServiceHelper.booksDetailsTransfer(booksDTO, booksVO);

            return booksVO;
        }
        catch(DaoException e)
        {
            throw new ServiceException(e);
        }
      
    }

    /**
     * (non-Javadoc).
     *
     * @param start the start
     * @param operator the operator
     * @return the list carrier vo
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.books.BooksManager#loadBooksDetails(int)
     */
    public ListCarrierVO loadBooksDetails(int start,UserValueObject operator) throws ServiceException 
    {
      try {
          
            LOGGER.info("LOADING IN MANAGER...");
            operatorDTO=ServiceHelper.serviceToDaoTransfer(operator, operatorDTO);
            
            ListCarrier listCarrier = booksManagerDao.loadBooksDetails(start,operatorDTO);

            List<BooksDTO> booksListDTO = listCarrier.getBooksListDTO();

            ListCarrierVO listCarrierVO = new ListCarrierVO();
            List<BooksVO> booksListVO = new ArrayList<BooksVO>();
            booksListVO = ServiceHelper.booksListTransfer(booksListDTO,booksListVO);
            listCarrierVO.setBooksListVO(booksListVO);
            listCarrierVO.setTotalRecords(listCarrier.getTotalRecords());
            
            LOGGER.info("RETURNING TO ACTION");
            return listCarrierVO;

        }
        catch(DaoException e)
        {
            throw new ServiceException(e);
        }
       
    }

    /**
     * (non-Javadoc)
     * This method updates a book details.
     *
     * @param booksVO the books vo
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.books.BooksManager#updateBooks(com.booksVibe.service
     * .valueObject.BooksVO)
     */
    public void updateBooks(BooksVO booksVO) throws ServiceException 
    {
      try 
      {
           int count = booksVO.getCopies() + booksVO.getNewcopies();
            booksVO.setCopies(count);
            LOGGER.info("COUNT" + booksVO.getCopies());

            booksDTO = ServiceHelper.booksTranfer(booksVO, booksDTO);

            booksManagerDao.updateBooks(booksDTO);
        }
        catch(DaoException e)
        {
            throw new ServiceException(e);
        }
       
    }

    /**
     * (non-Javadoc).
     *
     * @param booksId the books id
     * @throws ServiceException the service exception
     * @throws NoDeleteServiceException the no delete service exception
     * @see com.booksVibe.service.books.BooksManager#deleteBooks(int)
     */
    public void deleteBooks(int booksId) throws ServiceException,NoDeleteServiceException 
    {
      try {
            booksManagerDao.deleteBooks(booksId);
      } 
       catch (NoDeleteException e) 
       {
            LOGGER.error("CANNOT DELETE THE BOOKS" + e);
            throw new NoDeleteServiceException(e);
        }
        catch(DaoException e)
        {
            throw new ServiceException(e);
        }
       
    }

    /**
     * (non-Javadoc).
     *
     * @param booksVO the books vo
     * @param start the start
     * @param userEmailId the user email id
     * @return the list carrier vo
     * @throws ServiceException the service exception
     * @see com.booksVibe.service.books.BooksManager#searchBooks(com.booksVibe.service
     * .valueObject.BooksVO, int, int)
     */
    public ListCarrierVO searchBooks(BooksVO booksVO, int start,String userEmailId) throws ServiceException 
    {
     try {
            LOGGER.info("REQUESTING IN MANAGER...");
            booksDTO = ServiceHelper.booksTranfer(booksVO, booksDTO);

            
            ListCarrier listCarrier = booksManagerDao.searchBooks(booksDTO,start,userEmailId);

            List<BooksDTO> booksListDTO = listCarrier.getBooksListDTO();
            LOGGER.info("SIZE OF LIST RECEIVED FROM DAO.."+ booksListDTO.size());
            ListCarrierVO listCarrierVO = new ListCarrierVO();
            List<BooksVO> booksListVO = new ArrayList<BooksVO>();
            booksListVO = ServiceHelper.booksListTransfer(booksListDTO,booksListVO);
            listCarrierVO.setBooksListVO(booksListVO);
            listCarrierVO.setTotalRecords(listCarrier.getTotalRecords());

            return listCarrierVO;

        }
        catch(DaoException e)
        {
            throw new ServiceException(e);
        }
        
    }
    
    
    /** (non-Javadoc)
     * @see com.booksVibe.service.books.BooksManager#newArrivals(java.lang.String)
     */
    public List<BooksVO> newArrivals(String userEmailId) throws ServiceException
    {
      try
      {
            List<BooksDTO> booksListDTO=booksManagerDao.newArrivals(userEmailId);
            
            List<BooksVO> booksListVO=new ArrayList<BooksVO>();
            booksListVO=ServiceHelper.booksListTransfer(booksListDTO, booksListVO);
            return booksListVO;
        }
        catch(DaoException e)
        {
            throw new ServiceException(e);
        }
       
       
    }
}
