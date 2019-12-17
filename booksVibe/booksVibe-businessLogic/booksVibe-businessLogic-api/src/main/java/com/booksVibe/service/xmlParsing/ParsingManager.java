package com.booksVibe.service.xmlParsing;

import java.util.List;

import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.SubsDetailsVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ParsingManager.
 */
public interface ParsingManager {

    /**
     * Adds the update records.
     * 
     * @param subsListVO
     *            the subs list vo
     * @throws ServiceException
     *             the service exception
     */
    void addUpdateRecords(List<SubsDetailsVO> subsListVO)
            throws ServiceException;

    /**
     * Delete records.
     * 
     * @param subsListVO
     *            the subs list vo
     * @throws ServiceException
     *             the service exception
     */
    void deleteRecords(List<SubsDetailsVO> subsListVO) throws ServiceException;
}
