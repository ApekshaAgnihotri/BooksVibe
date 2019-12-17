package com.booksVibe.daoImpl.books;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.exceptions.DaoException;
import com.booksVibe.dao.exceptions.NoDeleteException;
import com.booksVibe.daoImpl.util.Utility;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BooksManagerDaoImplTest {

   static SessionFactory sessionFactory;
    
        @BeforeClass
        public static void initFactory()
        {            
            sessionFactory=Utility.getSessionFactory();
        }

        
        @InjectMocks
        private BooksManagerDaoImpl booksManagerDaoImpl;
        
        @InjectMocks
        private BooksDTO booksDTO;
        
        @Test
        public void testAddBooksTrue() throws DaoException, NoDeleteException{
          
          UserDTO operator=new UserDTO();
          operator.setEmaild("apeksha@gmail.com");
          booksDTO.setAuthor("abc");
          booksDTO.setAvailability("available");
          booksDTO.setBookTitle("title");
          booksDTO.setCategory("category");
          booksDTO.setCopies(0);
          booksDTO.setImageFileName("imageFileName");
          booksDTO.setLanguage("language");
          booksDTO.setOperator(operator);
          booksDTO.setPublisher("publisher");
          assertEquals(true,booksManagerDaoImpl.addBooks(booksDTO, operator));
              
          
         
         Session session = sessionFactory.openSession();
          session.beginTransaction();
          booksManagerDaoImpl.deleteBooks(booksDTO.getBookId());
          session.getTransaction().commit();
          session.close();
        }
        
        @Test
        public void testAddBooksFalse() throws DaoException{
            UserDTO operator=new UserDTO();
            operator.setEmaild("apeksha@gmail.com");
            booksDTO.setAuthor("David G Pugh & Terry R Bacon");
            booksDTO.setBookTitle("Society in India");
           assertEquals(false,booksManagerDaoImpl.addBooks(booksDTO, operator));
           
        }
        
       @Test
       public void testGetBookByBookId() throws DaoException{
           assertNotNull(booksManagerDaoImpl.booksById(31));
       }
        
       @Test
       public void testUpdateBooks() throws DaoException{
           UserDTO operator=new UserDTO();
           operator.setEmaild("nisha.mahobia@impetus.co.in");
           booksDTO.setAuthor("David G Pugh & Terry R Bacon");
           booksDTO.setAvailability("available");
           booksDTO.setBookTitle("Society in India");
           booksDTO.setCategory("Novels");
           booksDTO.setCopies(10);
           booksDTO.setImageFileName("society in india.jpg");
           booksDTO.setLanguage("English");
           booksDTO.setOperator(operator);
           booksDTO.setPublisher("Popular Prakashan");
           booksDTO.setBookId(31);
           booksManagerDaoImpl.updateBooks(booksDTO);
           
       }
       
       @Test
       public void testLoadBookDetails() throws DaoException{
           UserDTO operator=new UserDTO();
           operator.setEmaild("apeksha@gmail.com");
           assertNotNull(booksManagerDaoImpl.loadBooksDetails(0, operator));
           
       }
       @Test
       public void testSearchBooks() throws DaoException{
           booksDTO.setAuthor("David G Pugh & Terry R Bacon");
           booksDTO.setBookTitle("Society in India");
           booksDTO.setCategory("Novels");
           booksDTO.setPublisher("Popular Prakashan");
           String emailId="aditya.solge@impetus.co.in";
          assertNotNull( booksManagerDaoImpl.searchBooks(booksDTO,0,emailId));
          booksDTO.setAuthor("David G Pugh & Terry R Bacon");
          booksDTO.setBookTitle("");
          booksDTO.setCategory("");
          booksDTO.setPublisher("");
          assertNotNull( booksManagerDaoImpl.searchBooks(booksDTO, 0,emailId));
          booksDTO.setAuthor("");
          booksDTO.setBookTitle("");
          booksDTO.setCategory("all");
          booksDTO.setPublisher("");
          assertNotNull( booksManagerDaoImpl.searchBooks(booksDTO, 0,emailId));
          booksDTO.setAuthor("");
          booksDTO.setBookTitle("");
          booksDTO.setCategory("");
          booksDTO.setPublisher("Popular Prakashan");
          assertNotNull( booksManagerDaoImpl.searchBooks(booksDTO, 0,emailId));
          booksDTO.setAuthor("");
          booksDTO.setBookTitle("Society in India");
          booksDTO.setCategory("");
          booksDTO.setPublisher("");
          assertNotNull( booksManagerDaoImpl.searchBooks(booksDTO, 0,emailId));
       }
      
       @Test
       public void testNewArrivals() throws DaoException{
           String emailId="aditya.solge@impetus.co.in";
           assertNotNull(booksManagerDaoImpl.newArrivals(emailId));     
       }
}
