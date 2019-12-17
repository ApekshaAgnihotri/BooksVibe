package com.booksVibe.actions.pdf;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.actions.constants.ActionConstants;
import com.booksVibe.dao.DTO.PdfDataCarrier;
import com.booksVibe.models.RequestBookBean;
import com.booksVibe.models.UserBean;
import com.booksVibe.service.exceptions.ServiceException;
import com.booksVibe.service.pdf.PdfManager;
import com.booksVibe.util.exception.UtilException;
import com.booksVibe.util.pdf.PdfUtility;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


// TODO: Auto-generated Javadoc
/**
 * The Class PdfAction.
 * This method perform action related to PDF generation
 */
public class PdfAction extends ActionSupport implements
        ModelDriven<RequestBookBean> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(PdfAction.class);
    
    /** The request. */
    private HttpServletRequest request = ServletActionContext.getRequest();
    
    /** The session. */
    private HttpSession session = request.getSession();
    
    /** The pdf list. */
    private static List<PdfDataCarrier> pdfList = null;
    
    /** The pdf input stream. */
    private InputStream pdfInputStream;

    /** The request bean. */
    @Autowired
    private RequestBookBean requestBean;

    /** The pdf manager. */
    @Autowired
    private PdfManager pdfManager;

   
    /**
     * Gets the pdf input stream.
     *
     * @return the pdf input stream
     */
    public InputStream getPdfInputStream() {
        return pdfInputStream;
    }

   
    /**
     * Gets the authors list.
     * This method fetches authors list.
     * @return the authors list
     */
    public String getAuthorsList()
    {
     try {
            List<String> authorsList = pdfManager.managePdf();
            LOGGER.info("LIST SIZE IN ACTION:" + authorsList.size());
            session.setAttribute("author", authorsList);
            UserBean userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute("userBean");
            return selectUser(userBean);
        } 
        catch (ServiceException e)
        {
            return ActionConstants.FAILURE;
        }
        catch (Exception e)
        {
            return ERROR;
        }

    }

    
    /**
     * Gets the filtered list.
     * 
     * @return the filtered list
     */
    public String getFilteredList()
    {
      try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            String category = (ServletActionContext.getRequest().getParameter("category"));
            String author = (ServletActionContext.getRequest().getParameter("author"));

            Date tempFromDate = dateFormat.parse((ServletActionContext.getRequest().getParameter("from")));
            Date tempToDate = dateFormat.parse((ServletActionContext.getRequest().getParameter("to")));

            java.sql.Date fromDate = new java.sql.Date(tempFromDate.getTime());
            java.sql.Date toDate = new java.sql.Date(tempToDate.getTime());

            pdfList = pdfManager.getBooksByFilter(author, category, fromDate,toDate);
            
            if(pdfList.size()==0){
                addActionMessage(getText("NoDataForPdf"));
            }
            
            request.setAttribute("pdfList", pdfList);
            UserBean userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute("userBean");
            
            return selectUser(userBean);

        } 
        catch (ParseException e)
        {
            addActionError(getText("DateNotNull"));
            UserBean userBean = (UserBean) ServletActionContext.getRequest().getSession().getAttribute("userBean");
            return selectUser(userBean);
        }

        catch (ServiceException e)
        {
            return ActionConstants.FAILURE;
        }
        catch (Exception e)
        {
            return ActionConstants.FAILURE;
        }

    }


    /**
     * Select user.
     *
     * @param userBean the user bean
     * @return the string
     */
    private String selectUser(UserBean userBean)
    {
        if (userBean.getRole().equalsIgnoreCase("master"))
        {
            return SUCCESS;
        }
        else 
        {
            return ActionConstants.SLAVE_ADMIN_PAGE;
        }
    }

    /**
     * Generate pdf.
     *
     * @return the string
     */
    public String generatePdf()
    {
        try 
        {
            PdfUtility pdfUtility = new PdfUtility();
            pdfInputStream = pdfUtility.generate(pdfList);
            if (pdfInputStream != null) {
                addActionMessage(getText("Pdf.Generated"));
                return SUCCESS;
            } else {
                addActionError(getText("Pdf.Failed"));
                return ERROR;
            }
        } 
        catch (UtilException e) 
        {
            addActionError("Pdf.Failed");
            return ERROR;
        } catch (Exception e)
        {
            return ActionConstants.FAILURE;
        }
    }

    /** (non-Javadoc)
     * @see com.opensymphony.xwork2.ModelDriven#getModel()
     */
    public RequestBookBean getModel() {
        // TODO Auto-generated method stub
        return requestBean;
    }

}
