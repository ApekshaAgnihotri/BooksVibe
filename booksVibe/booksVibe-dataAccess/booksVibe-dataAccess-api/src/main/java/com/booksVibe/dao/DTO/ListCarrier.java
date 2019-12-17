package com.booksVibe.dao.DTO;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ListCarrier.
 */
public class ListCarrier {

    /** The books list dto. */
    private List<BooksDTO> booksListDTO;

    /** The total records. */
    private long totalRecords;

    /**
     * Gets the books list dto.
     * 
     * @return the books list dto
     */
    public List<BooksDTO> getBooksListDTO() {
        return booksListDTO;
    }

    /**
     * Sets the books list dto.
     * 
     * @param booksListDTO
     *            the new books list dto
     */
    public void setBooksListDTO(List<BooksDTO> booksListDTO) {
        this.booksListDTO = booksListDTO;
    }

    /**
     * Gets the total records.
     * 
     * @return the total records
     */
    public long getTotalRecords() {
        return totalRecords;
    }

    /**
     * Sets the total records.
     * 
     * @param totalRecords
     *            the new total records
     */
    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

}
