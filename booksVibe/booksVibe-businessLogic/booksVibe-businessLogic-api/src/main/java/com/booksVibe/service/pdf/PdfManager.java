package com.booksVibe.service.pdf;

import java.util.Date;
import java.util.List;

import com.booksVibe.dao.DTO.PdfDataCarrier;
import com.booksVibe.service.exceptions.ServiceException;

// TODO: Auto-generated Javadoc
/**
 * The Interface PdfManager.
 */
public interface PdfManager {

    /**
     * Manage pdf.
     * 
     * @return the list
     * @throws ServiceException
     *             the service exception
     */
    List<String> managePdf() throws ServiceException;

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
     * @throws ServiceException
     *             the service exception
     */
    List<PdfDataCarrier> getBooksByFilter(String author, String category,
            Date fromDate, Date toDate) throws ServiceException;
}
