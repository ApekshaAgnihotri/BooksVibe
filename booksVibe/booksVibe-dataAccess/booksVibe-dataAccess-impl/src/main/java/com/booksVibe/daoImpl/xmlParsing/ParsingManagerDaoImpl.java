package com.booksVibe.daoImpl.xmlParsing;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.xmlParsing.ParsingManagerDao;
import com.booksVibe.daoImpl.daoConstants.DaoConstants;
import com.booksVibe.daoImpl.util.Utility;

// TODO: Auto-generated Javadoc
/**
 * The Class ParsingManagerDaoImpl.
 */
public class ParsingManagerDaoImpl implements ParsingManagerDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(ParsingManagerDaoImpl.class);

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.xmlParsing.ParsingManagerDao#addUpdateRecords(java.
     * util.List)
     */
    public void addUpdateRecords(List<SubsDetailsDTO> subsListDTO)
            throws DaoException {

        try {

            LOGGER.info("LIST IN DAO LAYER..");

            for (SubsDetailsDTO subsDetailsDTO : subsListDTO) {
                Session session = Utility.getSessionFactory().openSession();
                Criteria criteria = session
                        .createCriteria(SubsDetailsDTO.class);
                session.beginTransaction();

                LOGGER.info("PLAN NAME:" + subsDetailsDTO.getSubsName());
                criteria.add(Restrictions.eq("subsName",
                        subsDetailsDTO.getSubsName()));
                SubsDetailsDTO subsDTO = (SubsDetailsDTO) criteria
                        .uniqueResult();

                if (subsDTO != null) {
                    LOGGER.info("UPDATING PLANS");
                    String create = "UPDATE subscription_details SET max_books='"
                            + subsDetailsDTO.getMaxBooks()
                            + "', amount='"
                            + subsDetailsDTO.getAmount()
                            + "',time_period='"
                            + subsDetailsDTO.getTimePeriod()
                            + "' , status='"
                            + subsDetailsDTO.getStatus()
                            + "' WHERE subs_name='"
                            + subsDetailsDTO.getSubsName() + "'";
                    SQLQuery query = session.createSQLQuery(create);
                    LOGGER.info("Value: " + query.executeUpdate());
                } else {
                    LOGGER.info("INSERTING PLANS");
                    session.saveOrUpdate(subsDetailsDTO);
                }
                session.getTransaction().commit();

            }
            LOGGER.info("DONE");

        } catch (HibernateException e) {
            LOGGER.error("ERROR WHILE SAVING IN DATABASE" + e);
            throw new DaoException(e);
        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.dao.xmlParsing.ParsingManagerDao#deleteRecords(java.util
     * .List)
     */
    public void deleteRecords(List<SubsDetailsDTO> subsListDTO)
            throws DaoException {
        try {

            LOGGER.info("LIST IN DAO LAYER..");
            Session session = Utility.getSessionFactory().openSession();
            session.beginTransaction();
            
            LOGGER.info("DELETING LIST");

            for (SubsDetailsDTO subsDetailsDTO : subsListDTO) {
                Criteria criteria = session.createCriteria(SubsDetailsDTO.class);    
                criteria.add(Restrictions.eq("subsName",subsDetailsDTO.getSubsName()));
                SubsDetailsDTO sDto= (SubsDetailsDTO) criteria.uniqueResult();
                
                if(!sDto.equals("")){
                     sDto.setStatus(DaoConstants.INACTIVE);
                     session.update(sDto);
                }
                else{
                    LOGGER.error("NO ENTRY FOUND NAMED:"+subsDetailsDTO.getSubsName());
                }
            }

            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.error("ERROR WHILE SAVING IN DATABASE" + e);
            throw new DaoException(e);
        }
    }

}
