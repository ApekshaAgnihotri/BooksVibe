package com.booksVibe.service.valueObjects;

import static org.junit.Assert.*;

import org.junit.Test;

import com.booksVibe.dao.DTO.RecommendBooksDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.RecommendBooksVO;
import com.booksVibe.service.valueObject.UserValueObject;

public class RecommendBooksVOTest {

    RecommendBooksVO recommendBooksVO=new RecommendBooksVO();
    
     @Test
     public void testRecommendBooksVO(){
         BooksVO booksVO=new BooksVO();
         UserValueObject userValueObject=new UserValueObject();
         recommendBooksVO.setBooksVO(booksVO);
         recommendBooksVO.setUserValueObject(userValueObject);
         recommendBooksVO.setId(0);
         
         assertEquals(booksVO, recommendBooksVO.getBooksVO());
         assertEquals(0, recommendBooksVO.getId());
         assertEquals(userValueObject,recommendBooksVO.getUserValueObject());
     }
}
