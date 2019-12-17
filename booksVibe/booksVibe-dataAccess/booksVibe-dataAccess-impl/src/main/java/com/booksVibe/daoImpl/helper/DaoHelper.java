package com.booksVibe.daoImpl.helper;

import org.apache.log4j.Logger;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class DaoHelper.
 */
public final class DaoHelper {

    private DaoHelper() {
    }

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(DaoHelper.class);

    /**
     * User subs details transfer.
     * 
     * @param userSubsDTO
     *            the user subs dto
     * @param subsDetailsDTO
     *            the subs details dto
     * @return the user subs dto
     */
    public static UserSubsDTO userSubsDetailsTransfer(UserSubsDTO userSubsDTO,
            SubsDetailsDTO subsDetailsDTO) {

        userSubsDTO.setSubsid(subsDetailsDTO.getSubsid());
        userSubsDTO.setMaxBooks(subsDetailsDTO.getMaxBooks());
        userSubsDTO.setSubsName(subsDetailsDTO.getSubsName());
        userSubsDTO.setTimePeriod(subsDetailsDTO.getTimePeriod());
        userSubsDTO.setAmmount(subsDetailsDTO.getAmount());

        LOGGER.info("OBJECT TRANSFFERED");
        return userSubsDTO;
    }

}
