package com.booksVibe.models;

import java.io.File;

// TODO: Auto-generated Javadoc
/**
 * The Class SubsDetailsBean.
 */
public class SubsDetailsBean {

    /** The subsid. */
    private int subsid;

    /** The subs name. */
    private String subsName;

    /** The max books. */
    private int maxBooks;

    /** The amount. */
    private float amount;

    /** The time period. */
    private int timePeriod;

    /** The status. */
    private String status;

    /** The xmlfile. */
    private File xmlfile;

    /** The xmlfile name. */
    private String xmlfileName;

    /** The xmlfile content type. */
    private String xmlfileContentType;

    /**
     * Gets the xmlfile name.
     * 
     * @return the xmlfile name
     */
    public String getXmlfileName() {
        return xmlfileName;
    }

    /**
     * Sets the xmlfile name.
     * 
     * @param xmlfileName
     *            the new xmlfile name
     */
    public void setXmlfileName(String xmlfileName) {
        this.xmlfileName = xmlfileName;
    }

    /**
     * Gets the xmlfile content type.
     * 
     * @return the xmlfile content type
     */
    public String getXmlfileContentType() {
        return xmlfileContentType;
    }

    /**
     * Sets the xmlfile content type.
     * 
     * @param xmlfileContentType
     *            the new xmlfile content type
     */
    public void setXmlfileContentType(String xmlfileContentType) {
        this.xmlfileContentType = xmlfileContentType;
    }

    /**
     * Gets the xmlfile.
     * 
     * @return the xmlfile
     */
    public File getXmlfile() {
        return xmlfile;
    }

    /**
     * Sets the xmlfile.
     * 
     * @param xmlfile
     *            the new xmlfile
     */
    public void setXmlfile(File xmlfile) {
        this.xmlfile = xmlfile;
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
