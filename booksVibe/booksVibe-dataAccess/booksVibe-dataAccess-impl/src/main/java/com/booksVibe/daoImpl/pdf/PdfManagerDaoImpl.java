package com.booksVibe.daoImpl.pdf;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.PdfDataCarrier;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.pdf.PdfManagerDao;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfManagerDaoImpl.
 */
public class PdfManagerDaoImpl implements PdfManagerDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(PdfManagerDaoImpl.class);
   private static final String ALL="all",AND="AND";
   
    /**
     * (non-Javadoc)
     * 
     * @see com.booksVibe.dao.pdf.PdfManagerDao#managePdf()
     */
    public List<String> managePdf() throws DaoException {
        // TODO Auto-generated method stub
        Session session = Utility.getSessionFactory().openSession();
        try {

            Criteria criteria = session
                    .createCriteria(BooksDTO.class)
                    .setProjection(
                            Projections.distinct(Projections.property("author")));

            List<String> authorsList = (List<String>) criteria.list();

            LOGGER.info("LIST RECIEVED FROM DATABASE.." + authorsList.size());

            return authorsList;

        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.pdf.PdfManagerDao#getBooksByFilter(java.lang.String,
     * java.lang.String, java.util.Date, java.util.Date)
     */
    public List<PdfDataCarrier> getBooksByFilter(String author,
            String category, Date fromDate, Date toDate) throws DaoException {
        Session session = Utility.getSessionFactory().openSession();
        try {

            String query;
           
            if (author.equalsIgnoreCase(ALL)
                    && category.equalsIgnoreCase(ALL)) {
                query = "SELECT b.category as category,b.author as author,b.title as title,COUNT(*)total, SUM(CASE WHEN br.request_status='cancelled' THEN 1 ELSE 0 END) cancelled,SUM(CASE WHEN br.request_status='returnRequest' THEN 1 ELSE 0 END)returned,SUM(CASE WHEN br.request_status='approved' THEN 1 ELSE 0 END)delivered FROM book_request br,books b WHERE br.request_date BETWEEN '"
                        + fromDate
                        + "' "+AND+" '"
                        + toDate
                        + "'  "+AND+" br.Book_Id=b.book_id GROUP BY br.Book_Id";
            } else if (author.equalsIgnoreCase(ALL)) {
                query = "SELECT b.category as category,b.author as author,b.title as title,COUNT(*)total, SUM(CASE WHEN br.request_status='cancelled' THEN 1 ELSE 0 END) cancelled,SUM(CASE WHEN br.request_status='returnRequest' THEN 1 ELSE 0 END)returned,SUM(CASE WHEN br.request_status='approved' THEN 1 ELSE 0 END)delivered FROM book_request br,books b WHERE br.request_date BETWEEN '"
                        + fromDate
                        + "' "+AND+" '"
                        + toDate
                        + "'  "+AND+"  br.Book_Id=b.book_id "+AND+" category='"
                        + category + "' GROUP BY br.Book_Id";
            } else if (category.equalsIgnoreCase(ALL)) {
                query = "SELECT b.category as category,b.author as author,b.title as title,COUNT(*)total, SUM(CASE WHEN br.request_status='cancelled' THEN 1 ELSE 0 END) cancelled,SUM(CASE WHEN br.request_status='returnRequest' THEN 1 ELSE 0 END)returned,SUM(CASE WHEN br.request_status='approved' THEN 1 ELSE 0 END)delivered FROM book_request br,books b WHERE br.request_date BETWEEN '"
                        + fromDate
                        + "' "+AND+" '"
                        + toDate
                        + "'  "+AND+" br.Book_Id=b.book_id "+AND+" author='"
                        + author + "'GROUP BY br.Book_Id";
            } else {
                query = "SELECT b.category as category,b.author as author,b.title as title,COUNT(*)total, SUM(CASE WHEN request_status='cancelled' THEN 1 ELSE 0 END) cancelled,SUM(CASE WHEN br.request_status='returnRequest' THEN 1 ELSE 0 END)returned,SUM(CASE WHEN br.request_status='approved' THEN 1 ELSE 0 END)delivered FROM book_request br,books b WHERE br.request_date BETWEEN '"
                        + fromDate
                        + "' "+AND+" '"
                        + toDate
                        + "'"+AND+" br.Book_Id=b.book_id "+AND+" category='"
                        + category
                        + "' "+AND+" author='"
                        + author
                        + "'GROUP BY br.Book_Id";
            }

            SQLQuery q = session.createSQLQuery(query);
            q.addScalar("returned", IntegerType.INSTANCE)
                    .addScalar("delivered", IntegerType.INSTANCE)
                    .addScalar("cancelled", IntegerType.INSTANCE)
                    .addScalar("title")
                    .addScalar("author")
                    .addScalar("category")
                    .setResultTransformer(
                            Transformers.aliasToBean(PdfDataCarrier.class));

            List<PdfDataCarrier> pdfList = (List<PdfDataCarrier>) q.list();
            LOGGER.info("SIZE:"+pdfList.size());
            return pdfList;
        } 
        catch (HibernateException e) 
        {
            LOGGER.error("EXCEPTION WHILE FETCHING FILTERED BOOKS." + e);
            throw new DaoException(e);
        } finally 
        {
            session.close();
        }
        // TODO Auto-generated method stub

    }

}
