package com.booksVibe.service.exceptions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RequestNotAllowedExceptionTest {

    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
        
    }
    
    
   @Test
    public void testNoDeleteServiceExcetpion(){
       
     RequestNotAllowedException requestNotAllowedException=new RequestNotAllowedException();
     assert(true);
    }
}
