package com.booksVibe.dao.DTO;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SubsDetailsDTO.
 */
@Entity
@Table(name = "subscription_details")
public class SubsDetailsDTO {

    /** The subsid. */
    @Id
    @GeneratedValue
    private int subsid;

    /** The subs name. */
    @Column(name = "subs_name")
    private String subsName;

    /** The max books. */
    @Column(name = "max_books")
    private int maxBooks;

    /** The amount. */
    private float amount;

    /** The time period. */
    @Column(name = "time_period")
    private int timePeriod;

    /** The status. */
    private String status;

    /**
     * Gets the status.
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     * 
     * @param status
     *            the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the subsid.
     * 
     * @return the subsid
     */
    public int getSubsid() {
        return subsid;
    }

    /**
     * Sets the subsid.
     * 
     * @param subsid
     *            the new subsid
     */
    public void setSubsid(int subsid) {
        this.subsid = subsid;
    }

    /**
     * Gets the subs name.
     * 
     * @return the subs name
     */
    public String getSubsName() {
        return subsName;
    }

    /**
     * Sets the subs name.
     * 
     * @param subsName
     *            the new subs name
     */
    public void setSubsName(String subsName) {
        this.subsName = subsName;
    }

    /**
     * Gets the max books.
     * 
     * @return the max books
     */
    public int getMaxBooks() {
        return maxBooks;
    }

    /**
     * Sets the max books.
     * 
     * @param maxBooks
     *            the new max books
     */
    public void setMaxBooks(int maxBooks) {
        this.maxBooks = maxBooks;
    }

    /**
     * Gets the amount.
     * 
     * @return the amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     * 
     * @param amount
     *            the new amount
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * Gets the time period.
     * 
     * @return the time period
     */
    public int getTimePeriod() {
        return timePeriod;
    }

    /**
     * Sets the time period.
     * 
     * @param timePeriod
     *            the new time period
     */
    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

}
