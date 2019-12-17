package com.booksVibe.dao.pdf;

import java.util.Date;
import java.util.List;

import com.booksVibe.dao.DTO.PdfDataCarrier;
import com.booksVibe.dao.exceptions.DaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface PdfManagerDao.
 */
public interface PdfManagerDao {

    /**
     * Manage pdf.
     * 
     * @return the list
     * @throws DaoException
     *             the dao exception
     */
    List<String> managePdf() throws DaoException;

    /**
     * Gets the books by filter.
     * 
     * @param author
     *            the author
     * @param category
     *            the category
     * @param fromDate
     *            the from date
     * @param toDate
     *            the to date
     * @return the books by filter
     * @throws DaoException
     *             the dao exception
     */
    List<PdfDataCarrier> getBooksByFilter(String author, String category,
            Date fromDate, Date toDate) throws DaoException;

}
