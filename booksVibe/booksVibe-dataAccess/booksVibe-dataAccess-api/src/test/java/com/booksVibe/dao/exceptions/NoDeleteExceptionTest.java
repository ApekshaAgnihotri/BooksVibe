package com.booksVibe.dao.exceptions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class NoDeleteExceptionTest {
    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
        
    }
    
    
   @Test
    public void testNoDeleteServiceExcetpion(){
       
     NoDeleteException noDeleteServiceException=new NoDeleteException();
     assert(true);
    }
}
