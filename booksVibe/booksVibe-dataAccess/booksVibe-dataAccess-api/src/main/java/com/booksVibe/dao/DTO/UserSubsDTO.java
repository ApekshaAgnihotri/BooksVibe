package com.booksVibe.dao.DTO;

import java.util.Date;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class UserSubsDTO.
 */
@Entity
@Table(name = "user_subscription_details")
public class UserSubsDTO {

    /** The emaild. */
    @Id
    @Column(name = "email_id")
    private String emaild;

    /** The subsid. */
    @Column(name = "subs_id")
    private int subsid;

    /** The max books. */
    @Column(name = "max_books")
    private int maxBooks;

    /** The time period. */
    @Column(name = "time_period")
    private int timePeriod;

    /** The sub start. */
    @Column(name = "subs_start")
    private Date subStart;

    /** The sub end. */
    @Column(name = "subs_end")
    private Date subEnd;

    /** The subs name. */
    @Column(name = "subs_name")
    private String subsName;

    /** The ammount. */
    private float ammount;

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
     * Gets the ammount.
     * 
     * @return the ammount
     */
    public float getAmmount() {
        return ammount;
    }

    /**
     * Sets the ammount.
     * 
     * @param ammount
     *            the new ammount
     */
    public void setAmmount(float ammount) {
        this.ammount = ammount;
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

}
