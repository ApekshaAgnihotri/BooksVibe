package com.booksVibe.serviceImpl.recommendation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.recommendation.RecommendBooksDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.recommendation.RecommendBooksManager;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.UserValueObject;
import com.booksVibe.serviceImpl.serviceHelper.ServiceHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class RecommendBooksManagerImpl.
 */
public class RecommendBooksManagerImpl implements RecommendBooksManager {

    /** The recommend books dao. */
    @Autowired
    private RecommendBooksDao recommendBooksDao;

    /** The user dto. */
    @Autowired
    private UserDTO userDTO;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(RecommendBooksManagerImpl.class);

    /**
     * (non-Javadoc)
     * 
     * @see com.booksVibe.service.recommendation.RecommendBooksManager#
     * getRecommendedBooks(com.booksVibe.service.valueObject.UserValueObject)
     */
    public List<BooksVO> getRecommendedBooks(UserValueObject userValueObject)
            throws ServiceException {
        // TODO Auto-generated method stub
        try {
            LOGGER.info("IN RECOMMEND BOOKS SERVICE");
            userDTO = ServiceHelper.serviceToDaoTransfer(userValueObject,userDTO);
            List<BooksDTO> booksListDTO = recommendBooksDao.getRecommendedBook(userDTO);

            List<BooksVO> booksListVO = new ArrayList<BooksVO>();
            booksListVO = ServiceHelper.booksListTransfer(booksListDTO, booksListVO);

            LOGGER.info("LIST SIZE IN MANAGER:" + booksListVO.size());
            return booksListVO;
        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
       

    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.recommendation.RecommendBooksManager#recommendBooks
     * ()
     */
    public void recommendBooks() throws ServiceException 
    {
        // TODO Auto-generated method stub
     try 
     {
            LOGGER.info("IN RECOMMEND BOOKS SERVICE");
            recommendBooksDao.recommendBooks();

     }
     catch(DaoException e)
     {
            throw new ServiceException(e);
      }
       
    }

}
