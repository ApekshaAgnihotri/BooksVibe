package com.booksVibe.service.valueObject;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ListCarrierVO.
 */
public class ListCarrierVO {

    /** The books list vo. */
    private List<BooksVO> booksListVO;

    /** The total records. */
    private long totalRecords;

    /**
     * Gets the books list vo.
     * 
     * @return the books list vo
     */
    public List<BooksVO> getBooksListVO() {
        return booksListVO;
    }

    /**
     * Sets the books list vo.
     * 
     * @param booksListVO
     *            the new books list vo
     */
    public void setBooksListVO(List<BooksVO> booksListVO) {
        this.booksListVO = booksListVO;
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
