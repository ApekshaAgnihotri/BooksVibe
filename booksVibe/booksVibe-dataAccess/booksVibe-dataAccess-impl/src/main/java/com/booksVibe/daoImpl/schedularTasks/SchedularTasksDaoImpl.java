package com.booksVibe.daoImpl.schedularTasks;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.schedularTasks.SchedularTasksDao;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class SchedularTasksDaoImpl.
 */
public class SchedularTasksDaoImpl implements SchedularTasksDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(SchedularTasksDaoImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.booksVibe.dao.schedularTasks.SchedularTasksDao#addBooks()
     */
    public void addBooks() throws DaoException {
        // TODO Auto-generated method stub
        try {
            SessionFactory sessionFactory = Utility.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            CreateTempTable.createTable();

            session = sessionFactory.openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("CALL addUpdateBooks()");
            LOGGER.info("TABLE UPDATED SUCCESSFULLY" + query.executeUpdate());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION WHILE UPDATING TABLE" + e);
            throw new DaoException(e);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.booksVibe.dao.schedularTasks.SchedularTasksDao#deleteBooks()
     */
    public void deleteBooks() throws DaoException {
        // TODO Auto-generated method stub
        try {

            CreateTempTable.createTable();
            LOGGER.info("TEMP TABLE CREATED SUCCESSFULLY....");

            LOGGER.info("DATA LOADED TO TEMPORARY TABLE");
            SessionFactory sessionFactory = Utility.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            SQLQuery query = session.createSQLQuery("CALL delete_books()");
            LOGGER.info("BOOKS DELETED SUCCESSFULLY..."
                    + +query.executeUpdate());

        } catch (HibernateException e) {
            LOGGER.error("EXCEPTION IN DELETEBOOKS SCHEDULARDAO..." + e);
            throw new DaoException(e);
        }

    }

}
