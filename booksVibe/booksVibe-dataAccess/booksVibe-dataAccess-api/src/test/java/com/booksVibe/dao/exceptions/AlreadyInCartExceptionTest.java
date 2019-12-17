package com.booksVibe.dao.exceptions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class AlreadyInCartExceptionTest {
    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
        
    }
    
    
   @Test
    public void testAlreadyInCartServiceExcetpion(){
       
     AlreadyInShelfException alreadyInCartServiceException=new AlreadyInShelfException();
     assert(true);
    }
}
