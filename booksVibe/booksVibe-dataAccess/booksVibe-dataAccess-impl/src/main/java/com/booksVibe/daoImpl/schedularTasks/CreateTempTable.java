package com.booksVibe.daoImpl.schedularTasks;

import org.apache.log4j.Logger;
import org.hibernate.*;

import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateTempTable.
 */
public final class CreateTempTable {

    private CreateTempTable() {
    }

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(CreateTempTable.class);

    /**
     * Creates the table.
     */
    public static void createTable() {

        SessionFactory sessionFactory = Utility.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        LOGGER.info("*******************CREATING TEMPORARY TABLE*********************");
        String create = "CREATE  TABLE tempy (title varchar(25),category varchar(15),author varchar(25),publisher varchar(25),copies int,language1 varchar(10),availability varchar(15),filename varchar(20),operatorId varchar(50))";
        SQLQuery query = session.createSQLQuery(create);
        LOGGER.info("Value: " + query.executeUpdate());
        session.getTransaction().commit();

        session.beginTransaction();
        LOGGER.info("***************Loading data into table****************");
        String csvDataRead = " LOAD DATA  INFILE '" + "d:\\dooks.csv"
                + "' INTO TABLE tempy "
                + " FIELDS TERMINATED BY \',\' ENCLOSED BY \'\"'"
                + " LINES TERMINATED BY \'\\r\\n\'";
        query = session.createSQLQuery(csvDataRead);
        LOGGER.info("Value: " + query.executeUpdate());
        session.getTransaction().commit();

    }
}
