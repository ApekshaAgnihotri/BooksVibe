package com.booksVibe.service.exceptions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NoDeleteServiceExceptionTest {
    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
        
    }
    
    
   @Test
    public void testNoDeleteServiceExcetpion(){
       
     NoDeleteServiceException noDeleteServiceException=new NoDeleteServiceException(new Exception());
     assert(true);
    }
    
}
