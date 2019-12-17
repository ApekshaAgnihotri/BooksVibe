package com.booksVibe.models;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class UserSubsBean.
 */
public class UserSubsBean {

    /** The email Id. */
    private String emaild;

    /** The subs Id. */
    private int subsid;

    /** The max books. */
    private int maxBooks;

    /** The time period. */
    private int timePeriod;

    /** The sub start. */
    private Date subStart;

    /** The sub end. */
    private Date subEnd;

    /** The status. */
    private String status;

    /** The subs name. */
    private String subsName;

    /** The amount. */
    private float amount;

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

    /**
     * Gets the sub start.
     * 
     * @return the sub start
     */
    public Date getSubStart() {
        return subStart;
    }

    /**
     * Sets the sub start.
     * 
     * @param subStart
     *            the new sub start
     */
    public void setSubStart(Date subStart) {
        this.subStart = subStart;
    }

    /**
     * Gets the sub end.
     * 
     * @return the sub end
     */
    public Date getSubEnd() {
        return subEnd;
    }

    /**
     * Sets the sub end.
     * 
     * @param subEnd
     *            the new sub end
     */
    public void setSubEnd(Date subEnd) {
        this.subEnd = subEnd;
    }

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

}
