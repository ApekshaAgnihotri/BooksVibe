package com.booksVibe.models;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestBookBean.
 */
public class RequestBookBean {

    /** The user bean. */
    private UserBean userBean;

    /** The operator bean. */
    private UserBean operatorBean;

    /** The books bean. */
    private BooksBean booksBean;

    /** The request id. */
    private int requestId;

    /** The request date. */
    private Date requestDate;

    /** The cancellation date. */
    private Date cancellationDate;

    /** The request status. */
    private String requestStatus;

    /** The return date. */
    private Date returnDate;

    /** The address. */
    private String address;

    /** The emaild. */
    private String emaild;

    /** The book title. */
    private String bookTitle;

    /** The author. */
    private String author;

    /** The book id. */
    private int bookId;

    /**
     * Gets the operator bean.
     * 
     * @return the operator bean
     */
    public UserBean getOperatorBean() {
        return operatorBean;
    }

    /**
     * Sets the operator bean.
     * 
     * @param operatorBean
     *            the new operator bean
     */
    public void setOperatorBean(UserBean operatorBean) {
        this.operatorBean = operatorBean;
    }

    /**
     * Gets the author.
     * 
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     * 
     * @param author
     *            the new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the request status.
     * 
     * @return the request status
     */
    public String getRequestStatus() {
        return requestStatus;
    }

    /**
     * Sets the request status.
     * 
     * @param requestStatus
     *            the new request status
     */
    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    /**
     * Gets the book id.
     * 
     * @return the book id
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Sets the book id.
     * 
     * @param bookId
     *            the new book id
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * Gets the emaild.
     * 
     * @return the emaild
     */
    public String getEmaild() {
        return emaild;
    }

    /**
     * Sets the emaild.
     * 
     * @param emaild
     *            the new emaild
     */
    public void setEmaild(String emaild) {
        this.emaild = emaild;
    }

    /**
     * Gets the book title.
     * 
     * @return the book title
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Sets the book title.
     * 
     * @param bookTitle
     *            the new book title
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * Gets the user bean.
     * 
     * @return the user bean
     */
    public UserBean getUserBean() {
        return userBean;
    }

    /**
     * Sets the user bean.
     * 
     * @param userBean
     *            the new user bean
     */
    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    /**
     * Gets the books bean.
     * 
     * @return the books bean
     */
    public BooksBean getBooksBean() {
        return booksBean;
    }

    /**
     * Sets the books bean.
     * 
     * @param booksBean
     *            the new books bean
     */
    public void setBooksBean(BooksBean booksBean) {
        this.booksBean = booksBean;
    }

    /**
     * Gets the request id.
     * 
     * @return the request id
     */
    public int getRequestId() {
        return requestId;
    }

    /**
     * Sets the request id.
     * 
     * @param requestId
     *            the new request id
     */
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    /**
     * Gets the request date.
     * 
     * @return the request date
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the request date.
     * 
     * @param requestDate
     *            the new request date
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * Gets the cancellation date.
     * 
     * @return the cancellation date
     */
    public Date getCancellationDate() {
        return cancellationDate;
    }

    /**
     * Sets the cancellation date.
     * 
     * @param cancellationDate
     *            the new cancellation date
     */
    public void setCancellationDate(Date cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    /**
     * Gets the return date.
     * 
     * @return the return date
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the return date.
     * 
     * @param returnDate
     *            the new return date
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * Gets the address.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * 
     * @param address
     *            the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
