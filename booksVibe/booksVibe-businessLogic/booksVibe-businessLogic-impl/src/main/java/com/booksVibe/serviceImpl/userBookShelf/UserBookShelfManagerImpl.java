package com.booksVibe.serviceImpl.userBookShelf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.UserBookShelfDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.AlreadyInShelfException;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.userBookShelf.UserBookShelfManagerDao;
import com.booksVibe.service.exceptions.AlreadyInShelfServiceException;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.userBookShelf.UserBookShelfManager;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.UserBookShelfVO;
import com.booksVibe.service.valueObject.UserValueObject;

import com.booksVibe.serviceImpl.serviceHelper.ServiceHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class CartManagerImpl.
 */
public class UserBookShelfManagerImpl implements UserBookShelfManager {

    
    /** The user value object. */
    @Autowired
    private UserValueObject userValueObject;

    /** The books vo. */
    @Autowired
    private BooksVO booksVO;

    /** The cart dto. */
    @Autowired
    private UserBookShelfDTO userBookShelfDTO;

    /** The user dto. */
    @Autowired
    private UserDTO userDTO;

    /** The books dto. */
    @Autowired
    private BooksDTO booksDTO;

    /** The cart manager dao. */
    @Autowired
    private UserBookShelfManagerDao userBookShelfManagerDao;

    /**
     * (non-Javadoc)
     * This method adds a book in the user's shelf
     * @see
     * com.booksVibe.service.userBookShelf.UserBooksShelfManager#addToShelf(com.booksVibe.service
     * .valueObject.UserBookShelfVO)
     */
    public void addToShelf(UserBookShelfVO userBookShelfVO) throws ServiceException,AlreadyInShelfServiceException 
    {
        // TODO Auto-generated method stub
     try {
         
            booksVO = userBookShelfVO.getBooksVO();
            userValueObject = userBookShelfVO.getUserVO();

            userDTO = ServiceHelper.serviceToDaoTransfer(userValueObject,userDTO);
            booksDTO = ServiceHelper.booksTranfer(booksVO, booksDTO);
            userBookShelfDTO.setBooksDTO(booksDTO);
            userBookShelfDTO.setUserDTO(userDTO);

            
            userBookShelfManagerDao.addToShelf(userBookShelfDTO);

        }
        catch (AlreadyInShelfException e) 
        {
            throw new AlreadyInShelfServiceException(e);
        
        }
        catch(DaoException e)
        {
            throw new ServiceException(e);
        }
        
       
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.userBookShelf.UserBookShelfManager#deleteFromShelf(com.booksVibe.service
     * .valueObject.UserBookShelfVO)
     */
    public void deleteFromShelf(UserBookShelfVO userBookShelfVO) throws ServiceException 
    {
        // TODO Auto-generated method stub
     try {
  
            booksVO = userBookShelfVO.getBooksVO();
            userValueObject = userBookShelfVO.getUserVO();

            userDTO = ServiceHelper.serviceToDaoTransfer(userValueObject, userDTO);

            booksDTO = ServiceHelper.booksTranfer(booksVO, booksDTO);

            userBookShelfDTO.setBooksDTO(booksDTO);
            userBookShelfDTO.setUserDTO(userDTO);

            userBookShelfManagerDao.deleteFromShelf(userBookShelfDTO);

        }
        catch(DaoException e)
        {
            throw new ServiceException(e);
        }
        
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.cart.CartManager#viewMyCart(com.booksVibe.service
     * .valueObject.UserCartVO)
     */
    public List<UserBookShelfVO> viewMyShelf(UserBookShelfVO userBookShelfVO)throws ServiceException 
    {
        // TODO Auto-generated method stub
     try {
     
            booksVO = userBookShelfVO.getBooksVO();
            userValueObject = userBookShelfVO.getUserVO();

            userDTO = ServiceHelper.serviceToDaoTransfer(userValueObject,userDTO);
            booksDTO = ServiceHelper.booksTranfer(booksVO, booksDTO);

            userBookShelfDTO.setBooksDTO(booksDTO);
            userBookShelfDTO.setUserDTO(userDTO);

            List<UserBookShelfDTO> booksInCartDTO = userBookShelfManagerDao.viewMyShelf(userBookShelfDTO);

            
            List<UserBookShelfVO> booksInCartVO = new ArrayList<UserBookShelfVO>();
            booksInCartVO = ServiceHelper.cartDetailsTransferDaoToService(booksInCartDTO, booksInCartVO);

            return booksInCartVO;

        }
        catch(DaoException e)
        {
            throw new ServiceException(e);
        }
       
    }

}
