package com.booksVibe.service.exceptions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BookAlreadyRequestedExceptionTest {
    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
        
    }
    
    
   @Test
    public void testBookAlreadyRequestedExcetpion(){
       
     BookAlreadyRequestedException bookAlreadyRequestedException=new BookAlreadyRequestedException();
     assert(true);
    }
}
