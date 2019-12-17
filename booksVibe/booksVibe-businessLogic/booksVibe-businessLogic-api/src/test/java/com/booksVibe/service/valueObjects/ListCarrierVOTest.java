package com.booksVibe.service.valueObjects;

import org.junit.Test;

import com.booksVibe.service.valueObject.ListCarrierVO;
import static org.junit.Assert.*;
public class ListCarrierVOTest {

    ListCarrierVO listCarrierVO=new ListCarrierVO();
    
    @Test
    public void testListCarrrierVO(){
     listCarrierVO.setBooksListVO(null)   ;
     listCarrierVO.setTotalRecords(0);
     
     assertEquals(0, listCarrierVO.getTotalRecords());
     assertNull(listCarrierVO.getBooksListVO());
    }
}
