package com.booksVibe.actions.xmlParsing;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.actions.constants.ActionConstants;
import com.booksVibe.actions.helper.ActionHelper;
import com.booksVibe.models.SubsDetailsBean;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.valueObject.SubsDetailsVO;
import com.booksVibe.service.xmlParsing.ParsingManager;
import com.booksVibe.util.SAXHandler.SAXHandler;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLParserSax.
 */
public class XMLParserSax extends ActionSupport implements
        ModelDriven<SubsDetailsBean> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(XMLParserSax.class);
    private String propertyFile = "path.properties";

    /** The subs details bean. */
    @Autowired
    private SubsDetailsBean subsDetailsBean;

    /** The parsing manager. */
    @Autowired
    private ParsingManager parsingManager;

    /**
     * Adds the update records.
     * This method firstly parse subscription plans from an xml file,
     * and insert new subscription plans or updates existing plans in the system.
     * 
     * @return the string
     */
    public String addUpdateRecords() {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
                LOGGER.info("PARSING IN ACTION");
                Properties property = new Properties();
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);
            property.load(inputStream);
            String path = property.getProperty("xmlPath");

            File xmlFile = new File(path,subsDetailsBean.getXmlfileContentType());
            FileUtils.copyFile(subsDetailsBean.getXmlfile(), xmlFile);

            LOGGER.info("FILE UPLOADED");
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            saxParser.parse(xmlFile, handler);
            List<SubsDetailsBean> subsList = handler.getSubsDetailsList();

            List<SubsDetailsVO> subsListVO = new ArrayList<SubsDetailsVO>();
            subsListVO = ActionHelper.subsListTransfer(subsList, subsListVO);

            parsingManager.addUpdateRecords(subsListVO);

            return SUCCESS;
        } 
        catch (ServiceException e) 
        {
            return ActionConstants.FAILURE;
        } catch (Exception e) {
            LOGGER.error("EXCEPTION IN ACTION" + e);
            return ERROR;
        }

    }

    /**
     * Delete records.
     * This method firstly parse subscription plans from an xml file
     * and change the status of the parsed plan from active to inactive.
     * @return the string
     */
    public String deleteRecords() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            Properties property = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertyFile);
            property.load(inputStream);
            String path = property.getProperty("xmlPath");

            File xmlFile = new File(path,subsDetailsBean.getXmlfileContentType());
            FileUtils.copyFile(subsDetailsBean.getXmlfile(), xmlFile);

            LOGGER.info("FILE UPLOADED");
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            saxParser.parse(xmlFile, handler);
            List<SubsDetailsBean> subsList = handler.getSubsDetailsList();

            List<SubsDetailsVO> subsListVO = new ArrayList<SubsDetailsVO>();
            subsListVO = ActionHelper.subsListTransfer(subsList, subsListVO);

            parsingManager.deleteRecords(subsListVO);
            return SUCCESS;
        }
        catch (ServiceException e) {
            return ActionConstants.FAILURE;
        }
        catch (Exception e) {
            return ERROR;
        }

    }

    public String uploadPlanPage() {
        return SUCCESS;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public SubsDetailsBean getModel() {
        // TODO Auto-generated method stub
        return subsDetailsBean;
    }

}
