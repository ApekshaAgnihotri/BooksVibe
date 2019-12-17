package com.booksVibe.service.valueObject;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestBookVO.
 */
public class RequestBookVO {

    /** The user vo. */
    private UserValueObject userVO;

    /** The operator vo. */
    private UserValueObject operatorVO;
    
    /** The books vo. */
    private BooksVO booksVO;
    
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

    /** The book id. */
    private int bookId;

       
    
    /**
     * Gets the operator vo.
     *
     * @return the operator vo
     */
    public UserValueObject getOperatorVO() {
        return operatorVO;
    }

    /**
     * Sets the operator vo.
     *
     * @param operatorVO the new operator vo
     */
    public void setOperatorVO(UserValueObject operatorVO) {
        this.operatorVO = operatorVO;
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
     * Gets the user vo.
     * 
     * @return the user vo
     */
    public UserValueObject getUserVO() {
        return userVO;
    }

    /**
     * Sets the user vo.
     * 
     * @param userVO
     *            the new user vo
     */
    public void setUserVO(UserValueObject userVO) {
        this.userVO = userVO;
    }

    /**
     * Gets the books vo.
     * 
     * @return the books vo
     */
    public BooksVO getBooksVO() {
        return booksVO;
    }

    /**
     * Sets the books vo.
     * 
     * @param booksVO
     *            the new books vo
     */
    public void setBooksVO(BooksVO booksVO) {
        this.booksVO = booksVO;
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
