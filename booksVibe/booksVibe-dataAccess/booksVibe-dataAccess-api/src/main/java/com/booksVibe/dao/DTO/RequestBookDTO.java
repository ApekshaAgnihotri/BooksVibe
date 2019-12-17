package com.booksVibe.dao.DTO;

import java.util.Date;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestBookDTO.
 */
@Entity
@Table(name = "Book_Request")
public class RequestBookDTO {

    /** The user dto. */
    @ManyToOne
    @JoinColumn(name="User_Id")
    private UserDTO userDTO;
    

    @ManyToOne
    @JoinColumn(name="Operator_Id")
    private UserDTO operator;


    /** The books dto. */
    @ManyToOne
    @JoinColumn(name="Book_Id")
    private BooksDTO booksDTO;
    
    /** The request id. */
    @Id
    @GeneratedValue
    @Column(name = "request_id")
    private int requestId;

    /** The request date. */
    @Column(name = "request_date")
    @Temporal(TemporalType.DATE)
    private Date requestDate;

    /** The cancellation date. */
    @Column(name = "cancellation_date")
    @Temporal(TemporalType.DATE)
    private Date cancellationDate;

    /** The request status. */
    @Column(name = "request_status")
    private String requestStatus;

    /** The return date. */
    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    /** The address. */
    private String address;
    
   

    public UserDTO getOperator() {
        return operator;
    }

    public void setOperator(UserDTO operator) {
        this.operator = operator;
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
     * Gets the user dto.
     * 
     * @return the user dto
     */
    public UserDTO getUserDTO() {
        return userDTO;
    }

    /**
     * Sets the user dto.
     * 
     * @param userDTO
     *            the new user dto
     */
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    /**
     * Gets the books dto.
     * 
     * @return the books dto
     */
    public BooksDTO getBooksDTO() {
        return booksDTO;
    }

    /**
     * Sets the books dto.
     * 
     * @param booksDTO
     *            the new books dto
     */
    public void setBooksDTO(BooksDTO booksDTO) {
        
        this.booksDTO = booksDTO;
       
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
