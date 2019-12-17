package com.booksVibe.service.exceptions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class ServiceExceptionTest {


    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
        
    }
    
    
   @Test
    public void testServiceExcetpion(){
       
     ServiceException serviceException=new ServiceException(new Exception());
     assert(true);
    }
}
