package com.booksVibe.serviceImpl.webService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.registration.RegManagerDao;

import com.booksVibe.service.valueObject.SubsDetailsVO;
import com.booksVibe.serviceImpl.serviceHelper.ServiceHelper;



@WebService
@SOAPBinding(style=Style.RPC ,parameterStyle=SOAPBinding.ParameterStyle.WRAPPED,use = SOAPBinding.Use.LITERAL)
public class ShowSubscriptionPlansServiceImpl {

    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(ShowSubscriptionPlansServiceImpl.class);
    
    
    @Autowired
    private RegManagerDao regManagerDaoImpl;
    
    
    @WebMethod(operationName="showSubscriptionPlansService")
    public SubsDetailsVO[] showSubscriptonPlans()
    {
        try{
            List<SubsDetailsDTO> subsList = regManagerDaoImpl.loadSubscription();

            List<SubsDetailsVO> subsListVO = new ArrayList<SubsDetailsVO>();
            Iterator<SubsDetailsDTO> it = subsList.iterator();

            while (it.hasNext()) {

                SubsDetailsVO subsDetailsVO = new SubsDetailsVO();
                SubsDetailsDTO subsDetailsDTO = (SubsDetailsDTO) it.next();
                SubsDetailsVO subsDetailVO = ServiceHelper.subsDetailsTransfer(subsDetailsDTO, subsDetailsVO);
                subsListVO.add(subsDetailVO);
               
            }
            return subsListVO.toArray(new SubsDetailsVO[subsListVO.size()]);
            
        }
        catch(DaoException e){
             LOGGER.info("EXCEPTION IN WEB SERVICE"+e);
             return null;
        }
       
      }
    
}
