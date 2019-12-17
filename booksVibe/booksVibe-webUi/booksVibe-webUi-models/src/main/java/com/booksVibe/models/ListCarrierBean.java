package com.booksVibe.models;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ListCarrierBean.
 */
public class ListCarrierBean {

    /** The books list bean. */
    private List<BooksBean> booksListBean;

    /** The total records. */
    private int totalRecords;

    /**
     * Gets the books list bean.
     * 
     * @return the books list bean
     */
    public List<BooksBean> getBooksListBean() {
        return booksListBean;
    }

    /**
     * Sets the books list bean.
     * 
     * @param booksListBean
     *            the new books list bean
     */
    public void setBooksListBean(List<BooksBean> booksListBean) {
        this.booksListBean = booksListBean;
    }

    /**
     * Gets the total records.
     * 
     * @return the total records
     */
    public int getTotalRecords() {
        return totalRecords;
    }

    /**
     * Sets the total records.
     * 
     * @param totalRecords
     *            the new total records
     */
    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

}
