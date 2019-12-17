package com.booksVibe.dao.xmlParsing;

import java.util.List;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.exceptions.DaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParsingManagerDao.
 */
public interface ParsingManagerDao {

    /**
     * Adds the update records.
     * 
     * @param subsListDTO
     *            the subs list dto
     * @throws DaoException
     *             the dao exception
     */
    void addUpdateRecords(List<SubsDetailsDTO> subsListDTO) throws DaoException;

    /**
     * Delete records.
     * 
     * @param subListDTO
     *            the sub list dto
     * @throws DaoException
     *             the dao exception
     */
    void deleteRecords(List<SubsDetailsDTO> subListDTO) throws DaoException;
}
