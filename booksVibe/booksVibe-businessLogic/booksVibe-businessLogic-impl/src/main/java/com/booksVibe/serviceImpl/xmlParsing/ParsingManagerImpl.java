package com.booksVibe.serviceImpl.xmlParsing;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.xmlParsing.ParsingManagerDao;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.SubsDetailsVO;
import com.booksVibe.service.xmlParsing.ParsingManager;
import com.booksVibe.serviceImpl.serviceHelper.ServiceHelper;

// TODO: Auto-generated Javadoc
/**
 * The Class ParsingManagerImpl.
 */
public class ParsingManagerImpl implements ParsingManager {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger
            .getLogger(ParsingManagerImpl.class);

    /** The parsing manager dao impl. */
    @Autowired
    private ParsingManagerDao parsingManagerDaoImpl;

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.xmlParsing.ParsingManager#addUpdateRecords(java
     * .util.List)
     */
    public void addUpdateRecords(List<SubsDetailsVO> subsListVO)
            throws ServiceException {

        try {
            LOGGER.info("LIST IN SERVICE LAYER");

            List<SubsDetailsDTO> subsListDTO = new ArrayList<SubsDetailsDTO>();
            subsListDTO = ServiceHelper.subsTransferFromVOToDTO(subsListDTO,
                    subsListVO);

            parsingManagerDaoImpl.addUpdateRecords(subsListDTO);

        } catch(DaoException e){
            throw new ServiceException(e);
        }

    }

    /**
     * (non-Javadoc)
     * 
     * @see
     * com.booksVibe.service.xmlParsing.ParsingManager#deleteRecords(java.util
     * .List)
     */
    public void deleteRecords(List<SubsDetailsVO> subsListVO)
            throws ServiceException {
        try {

            LOGGER.info("LIST IN SERVICE LAYER");
            List<SubsDetailsDTO> subsListDTO = new ArrayList<SubsDetailsDTO>();
            subsListDTO = ServiceHelper.subsTransferFromVOToDTO(subsListDTO,
                    subsListVO);

            parsingManagerDaoImpl.deleteRecords(subsListDTO);

        }  catch(DaoException e){
            throw new ServiceException(e);
        }
    }

}
