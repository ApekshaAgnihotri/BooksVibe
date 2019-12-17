package com.booksVibe.dao.requestBook;

import java.util.List;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.dao.exceptions.DaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface RequestBookManagerDao.
 */
public interface RequestBookManagerDao {

    /**
     * Request book.
     * 
     * @param requestDTO
     *            the request dto
     * @throws DaoException
     *             the dao exception
     */
    void requestBook(RequestBookDTO requestDTO) throws DaoException;

    /**
     * If already requested.
     * 
     * @param requestDTO
     *            the request dto
     * @return the boolean
     * @throws DaoException
     *             the dao exception
     */
    Boolean ifAlreadyRequested(RequestBookDTO requestDTO) throws DaoException;

    /**
     * Gets the subscribed plan.
     * 
     * @param requestDTO
     *            the request dto
     * @return the subscribed plan
     * @throws DaoException
     *             the dao exception
     */
    UserSubsDTO getSubscribedPlan(RequestBookDTO requestDTO)
            throws DaoException;

    /**
     * Count holding books.
     * 
     * @param requestDTO
     *            the request dto
     * @return the integer
     * @throws DaoException
     *             the dao exception
     */
    Integer countHoldingBooks(RequestBookDTO requestDTO) throws DaoException;

    /**
     * Count requested books.
     * 
     * @param requestDTO
     *            the request dto
     * @return the integer
     * @throws DaoException
     *             the dao exception
     */
    Integer countRequestedBooks(RequestBookDTO requestDTO) throws DaoException;

    /**
     * Update book copies.
     * 
     * @param booksDTO
     *            the books dto
     * @throws DaoException
     *             the dao exception
     */
    void updateBookCopies(BooksDTO booksDTO) throws DaoException;

    /**
     * View requested books.
     * 
     * @param requestDTO
     *            the request dto
     * @return the list
     * @throws DaoException
     *             the dao exception
     */
    List<RequestBookDTO> viewRequestedBooks(RequestBookDTO requestDTO)
            throws DaoException;

    /**
     * Gets the book details by id.
     * 
     * @param bookId
     *            the book id
     * @return the book details by id
     * @throws DaoException
     *             the dao exception
     */
    BooksDTO getBookDetailsById(int bookId) throws DaoException;

    /**
     * View issued books.
     * 
     * @param requestDTO
     *            the request dto
     * @return the list
     * @throws DaoException
     *             the dao exception
     */
    List<RequestBookDTO> viewIssuedBooks(RequestBookDTO requestDTO)
            throws DaoException;

    /**
     * Cancel deleivery request.
     * 
     * @param requestDTO
     *            the request dto
     * @throws DaoException
     *             the dao exception
     */
    void cancelDeleiveryRequest(RequestBookDTO requestDTO) throws DaoException;

    /**
     * Book return request.
     * 
     * @param requestDTO
     *            the request dto
     * @throws DaoException
     *             the dao exception
     */
    void bookReturnRequest(RequestBookDTO requestDTO) throws DaoException;

    /**
     * View to be returned books.
     * 
     * @param requestDTO
     *            the request dto
     * @return the list
     * @throws DaoException
     *             the dao exception
     */
    List<RequestBookDTO> viewToBeReturnedBooks(RequestBookDTO requestDTO)
            throws DaoException;

    /**
     * Cancel return request.
     * 
     * @param requestDTO
     *            the request dto
     * @throws DaoException
     *             the dao exception
     */
    void cancelReturnRequest(RequestBookDTO requestDTO) throws DaoException;

    /**
     * View my history.
     * 
     * @param requestDTO
     *            the request dto
     * @return the list
     * @throws DaoException
     *             the dao exception
     */
    List<RequestBookDTO> viewMyHistory(RequestBookDTO requestDTO)
            throws DaoException;

    boolean checkIfPlanIsActive(RequestBookDTO requestBookDTO)throws DaoException;
}
