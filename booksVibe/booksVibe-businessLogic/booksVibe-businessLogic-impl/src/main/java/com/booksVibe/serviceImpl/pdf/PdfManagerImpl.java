package com.booksVibe.serviceImpl.pdf;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.PdfDataCarrier;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.pdf.PdfManagerDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.pdf.PdfManager;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfManagerImpl.
 */
public class PdfManagerImpl implements PdfManager {

    /** The pdf manager dao. */
    @Autowired
    private PdfManagerDao pdfManagerDao;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(PdfManagerImpl.class);

    /**
     * (non-Javadoc)
     * 
     * @see com.booksVibe.service.pdf.PdfManager#managePdf()
     */
    public List<String> managePdf() throws ServiceException {
        try {
            LOGGER.info("IN SERVICE LAYER");
            List<String> authorsList = pdfManagerDao.managePdf();

            return authorsList;

        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
       

    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.pdf.PdfManager#getBooksByFilter(java.lang.String,
     * java.lang.String, java.util.Date, java.util.Date)
     */
    public List<PdfDataCarrier> getBooksByFilter(String author,
            String category, Date fromDate, Date toDate)
            throws ServiceException {
        // TODO Auto-generated method stub
        try {

            List<PdfDataCarrier> pdfList = pdfManagerDao.getBooksByFilter(
                    author, category, fromDate, toDate);

            return pdfList;

        }
        catch(DaoException e){
            throw new ServiceException(e);
        }
        

    }
}
