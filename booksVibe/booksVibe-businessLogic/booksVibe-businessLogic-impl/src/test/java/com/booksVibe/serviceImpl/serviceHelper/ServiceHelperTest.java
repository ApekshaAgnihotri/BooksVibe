package com.booksVibe.serviceImpl.serviceHelper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.DTO.UserBookShelfDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.SubsDetailsVO;
import com.booksVibe.service.valueObject.UserBookShelfVO;
import com.booksVibe.service.valueObject.UserSubsVO;



@RunWith(MockitoJUnitRunner.class)
public class ServiceHelperTest {

    
    @InjectMocks
    private SubsDetailsDTO subsDetailsDTO;
    
   
   
    
   @Test
   public void testSubsObjectsTransferVOToDTO(){
       SubsDetailsVO subsDetailsVO=new SubsDetailsVO();
       subsDetailsVO.setAmount(232);
       subsDetailsVO.setMaxBooks(2);
       subsDetailsVO.setStatus("active");
       subsDetailsVO.setSubsName("testPlan");
       subsDetailsVO.setTimePeriod(0);
       
       SubsDetailsDTO subsDetailsDTO=new SubsDetailsDTO();
        assertNotNull(ServiceHelper.subsObjectsTransferVOToDTO(subsDetailsDTO, subsDetailsVO));
        
        List<SubsDetailsDTO> listDTO=new ArrayList<SubsDetailsDTO>();
        List<SubsDetailsVO> listVO=new ArrayList<SubsDetailsVO>();
        listVO.add(subsDetailsVO);
        assertNotNull(ServiceHelper.subsTransferFromVOToDTO(listDTO, listVO));
       
   }
   
   @Test
   public void testCartTransfer(){
       UserBookShelfDTO cartDTO=new UserBookShelfDTO();
       BooksDTO booksDTO=new BooksDTO();
       UserDTO userDTO=new UserDTO();
       UserBookShelfVO cartVO= new UserBookShelfVO();
       cartDTO.setBooksDTO(booksDTO);
       cartDTO.setUserDTO(userDTO);
       cartDTO.setCartId(0);
       assertNotNull(ServiceHelper.cartTransfer(cartDTO, cartVO));
       List<UserBookShelfDTO> listDTO=new ArrayList<UserBookShelfDTO>();
       List<UserBookShelfVO> listVO=new ArrayList<UserBookShelfVO>();
       listDTO.add(cartDTO);
       assertNotNull(ServiceHelper.cartDetailsTransferDaoToService(listDTO, listVO));
       
   }
   
   @Test
   public void testuserSubsDetailsTransfer(){
       UserSubsDTO subsDetailsVO=new UserSubsDTO();
       subsDetailsVO.setEmaild("aman@gmail.com");
       subsDetailsVO.setAmmount(232);
       subsDetailsVO.setMaxBooks(2);
       subsDetailsVO.setStatus("active");
       subsDetailsVO.setSubsName("testPlan");
       subsDetailsVO.setTimePeriod(0);
       
       
       List<UserSubsDTO> listDTO=new ArrayList<UserSubsDTO>();
       List<UserSubsVO> listVo=new ArrayList<UserSubsVO>();
       listDTO.add(subsDetailsVO);
       assertNotNull(ServiceHelper.usersSubsDetailsTransfer(listDTO, listVo));
   }
   
   @Test
   public void testRequestBookTransferDaoToService(){
       RequestBookDTO requestBookDTO=new RequestBookDTO();
       BooksDTO booksDTO=new BooksDTO();
       
       UserDTO userDTO=new UserDTO();
       UserDTO operator=new UserDTO();
       requestBookDTO.setBooksDTO(booksDTO);
       requestBookDTO.setUserDTO(userDTO);
       requestBookDTO.setOperator(operator);
       RequestBookVO requestVO=new RequestBookVO();
       assertNotNull(ServiceHelper.requestTransferDaoToService(requestBookDTO, requestVO));
       
       List<RequestBookDTO> listDTO=new ArrayList<RequestBookDTO>();
       List<RequestBookVO> listVO=new ArrayList<RequestBookVO>();
       listDTO.add(requestBookDTO);
       assertNotNull(ServiceHelper.requestedBooksListTransferServiceToDao(listVO, listDTO));
       
   }
}
