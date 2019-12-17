package com.booksVibe.util.SAXHandler;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.booksVibe.models.SubsDetailsBean;

// TODO: Auto-generated Javadoc
/**
 * The Class SAXHandler.
 */
public class SAXHandler extends DefaultHandler {

    /** The subs details bean. */
    private SubsDetailsBean subsDetailsBean = null;

    /** The subs details list. */
    private List<SubsDetailsBean> subsDetailsList = null;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(SAXHandler.class);

    /** The subs name. */
    private boolean subsName = false;

    /** The max books. */
    private boolean maxBooks = false;

    /** The amount. */
    private boolean amount = false;

    /** The time period. */
    private boolean timePeriod = false;

    /** The status. */
    private boolean status = false;

    /**
     * Gets the subs details list.
     * 
     * @return the subs details list
     */
    public List<SubsDetailsBean> getSubsDetailsList() {
        return subsDetailsList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
     * java.lang.String, java.lang.String, org.xml.sax.Attributes)
     */
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        LOGGER.info("START ELEMENT" + qName);
        try {
            if (qName.equalsIgnoreCase("Subscription")) {
                subsDetailsBean = new SubsDetailsBean();

                if (subsDetailsList == null) {
                    subsDetailsList = new ArrayList<SubsDetailsBean>();
                }
            } else if (qName.equalsIgnoreCase("subsName")) {

                subsName = true;

            } else if (qName.equalsIgnoreCase("maxBooks")) {

                maxBooks = true;

            } else if (qName.equalsIgnoreCase("amount")) {

                amount = true;

            } else if (qName.equalsIgnoreCase("timePeriod")) {

                timePeriod = true;

            } else if (qName.equalsIgnoreCase("status")) {

                status = true;
            }
        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN SAX HANDLER" + e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        if (qName.equalsIgnoreCase("Subscription")) {
            subsDetailsList.add(subsDetailsBean);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
     */
    public void characters(char ch[], int start, int length)
            throws SAXException {
        try {
            if (subsName) {

                subsDetailsBean.setSubsName(new String(ch, start, length));

                subsName = false;

            } else if (maxBooks) {

                subsDetailsBean.setMaxBooks(Integer.parseInt(new String(ch,
                        start, length)));

                maxBooks = false;

            } else if (amount) {

                subsDetailsBean.setAmount(Float.parseFloat(new String(ch,
                        start, length)));

                amount = false;

            } else if (timePeriod) {

                subsDetailsBean.setTimePeriod(Integer.parseInt(new String(ch,
                        start, length)));

                timePeriod = false;

            } else if (status) {

                subsDetailsBean.setStatus(new String(ch, start, length));

                status = false;
            }

        } catch (NumberFormatException e) {
            LOGGER.error("FAULTY RECORD" + e);

        }
    }
}
