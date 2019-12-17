package com.booksVibe.models;

import static org.junit.Assert.*;

import org.junit.Test;


public class ListCarrierBeanTest {
  ListCarrierBean listCarrierVO=new ListCarrierBean();
    
    @Test
    public void testListCarrrierVO(){
     listCarrierVO.setBooksListBean(null)   ;
     listCarrierVO.setTotalRecords(0);
     
     assertEquals(0, listCarrierVO.getTotalRecords());
     assertNull(listCarrierVO.getBooksListBean());
}
}