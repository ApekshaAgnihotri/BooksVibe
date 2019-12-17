package com.booksVibe.serviceImpl.serviceHelper;

import java.util.Iterator;
import java.util.List;

import com.booksVibe.dao.DTO.BooksDTO;
import com.booksVibe.dao.DTO.RequestBookDTO;
import com.booksVibe.dao.DTO.SubsDetailsDTO;
import com.booksVibe.dao.DTO.UserBookShelfDTO;
import com.booksVibe.dao.DTO.UserDTO;
import com.booksVibe.dao.DTO.UserSubsDTO;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.SubsDetailsVO;
import com.booksVibe.service.valueObject.UserBookShelfVO;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceHelper.
 */
public final class ServiceHelper {

    private ServiceHelper() {
    }

    /**
     * Object transfer.
     * 
     * @param loginValueObject
     *            the login value object
     * @param loginDTO
     *            the login dto
     * @return the user value object
     */
    public static UserValueObject objectTransfer(UserValueObject loginValueObject, UserDTO loginDTO) {

        loginValueObject.setFirstname(loginDTO.getFirstname());
        loginValueObject.setLastname(loginDTO.getLastname());
        loginValueObject.setPassword(loginDTO.getPassword());
        loginValueObject.setAddress(loginDTO.getAddress());
        loginValueObject.setContactno(loginDTO.getContactno());
        loginValueObject.setEmaild(loginDTO.getEmaild());
        loginValueObject.setLanguage(loginDTO.getLanguage());
        loginValueObject.setSubsid(loginDTO.getSubsid());
         loginValueObject.setRole(loginDTO.getRole());
        return loginValueObject;
    }

    /**
     * Service to dao transfer.
     * 
     * @param userValueObject
     *            the user value object
     * @param userDTO
     *            the user dto
     * @return the user dto
     */
    public static UserDTO serviceToDaoTransfer(UserValueObject userValueObject,UserDTO userDTO) {

        userDTO.setFirstname(userValueObject.getFirstname());
        userDTO.setLastname(userValueObject.getLastname());
        userDTO.setPassword(userValueObject.getPassword());
        userDTO.setAddress(userValueObject.getAddress());
        userDTO.setContactno(userValueObject.getContactno());
        userDTO.setEmaild(userValueObject.getEmaild());
        userDTO.setLanguage(userValueObject.getLanguage());
        userDTO.setSubsid(userValueObject.getSubsid());
        userDTO.setRole(userValueObject.getRole());
        return userDTO;
    }

    /**
     * Subs details transfer.
     * 
     * @param subsDetailsDTO
     *            the subs details dto
     * @param subsDetailsVO
     *            the subs details vo
     * @return the subs details vo
     */
    public static SubsDetailsVO subsDetailsTransfer(
            SubsDetailsDTO subsDetailsDTO, SubsDetailsVO subsDetailsVO) {

        subsDetailsVO.setSubsid(subsDetailsDTO.getSubsid());
        subsDetailsVO.setAmount(subsDetailsDTO.getAmount());
        subsDetailsVO.setMaxBooks(subsDetailsDTO.getMaxBooks());
        subsDetailsVO.setSubsName(subsDetailsDTO.getSubsName());
        subsDetailsVO.setTimePeriod(subsDetailsDTO.getTimePeriod());

        return subsDetailsVO;

    }

    /**
     * Books tranfer.
     * 
     * @param booksVO
     *            the books vo
     * @param booksDTO
     *            the books dto
     * @return the books dto
     */
    public static BooksDTO booksTranfer(BooksVO booksVO, BooksDTO booksDTO) {

        booksDTO.setBookId(booksVO.getBookId());
        booksDTO.setAuthor(booksVO.getAuthor());
        booksDTO.setBookTitle(booksVO.getBookTitle());
        booksDTO.setCategory(booksVO.getCategory());
        booksDTO.setPublisher(booksVO.getPublisher());
        booksDTO.setCopies(booksVO.getCopies());
        booksDTO.setLanguage(booksVO.getLanguage());
        booksDTO.setImageFileName(booksVO.getImageFileName());
        booksDTO.setAvailability(booksVO.getAvailability());
               
        return booksDTO;

    }

    /**
     * Books details transfer.
     * 
     * @param booksDTO
     *            the books dto
     * @param booksVO
     *            the books vo
     * @return the books vo
     */
    public static BooksVO booksDetailsTransfer(BooksDTO booksDTO,
            BooksVO booksVO) {
       
        booksVO.setAuthor(booksDTO.getAuthor());
        booksVO.setBookId(booksDTO.getBookId());
        booksVO.setBookTitle(booksDTO.getBookTitle());
        booksVO.setCategory(booksDTO.getCategory());
        booksVO.setCopies(booksDTO.getCopies());
        booksVO.setLanguage(booksDTO.getLanguage());
        booksVO.setPublisher(booksDTO.getPublisher());
        booksVO.setInShelf(booksDTO.getInShelf());
        booksVO.setIsRequested(booksDTO.getIsRequested());
        booksVO.setAvailability(booksDTO.getAvailability());
     
        booksVO.setImageFileName(booksDTO.getImageFileName());
       
        return booksVO;
    }

    /**
     * Books list transfer.
     * 
     * @param booksListDTO
     *            the books list dto
     * @param booksListVO
     *            the books list vo
     * @return the list
     */
    public static List<BooksVO> booksListTransfer(List<BooksDTO> booksListDTO,
            List<BooksVO> booksListVO) {
        Iterator<BooksDTO> it = booksListDTO.iterator();

        while (it.hasNext()) {
            BooksVO booksVO = new BooksVO();
            BooksDTO booksDTO = (BooksDTO) it.next();
            BooksVO bookVO = ServiceHelper.booksDetailsTransfer(booksDTO,
                    booksVO);
            booksListVO.add(bookVO);
        }
        return booksListVO;
    }

    /**
     * Subs transfer from vo to dto.
     * 
     * @param subsListDTO
     *            the subs list dto
     * @param subsListVO
     *            the subs list vo
     * @return the list
     */
    public static List<SubsDetailsDTO> subsTransferFromVOToDTO(
            List<SubsDetailsDTO> subsListDTO, List<SubsDetailsVO> subsListVO) {
        Iterator<SubsDetailsVO> it = subsListVO.iterator();
        while (it.hasNext()) {
            SubsDetailsDTO subsDetailsDTO = new SubsDetailsDTO();
            SubsDetailsVO subsDetailsVO = (SubsDetailsVO) it.next();
            subsDetailsDTO = ServiceHelper.subsObjectsTransferVOToDTO(
                    subsDetailsDTO, subsDetailsVO);
            subsListDTO.add(subsDetailsDTO);

        }
        return subsListDTO;

    }

    /**
     * Subs objects transfer vo to dto.
     * 
     * @param subsDetailsDTO
     *            the subs details dto
     * @param subsDetailsVO
     *            the subs details vo
     * @return the subs details dto
     */
    public static SubsDetailsDTO subsObjectsTransferVOToDTO(
            SubsDetailsDTO subsDetailsDTO, SubsDetailsVO subsDetailsVO) {
        subsDetailsDTO.setAmount(subsDetailsVO.getAmount());
        subsDetailsDTO.setMaxBooks(subsDetailsVO.getMaxBooks());
        subsDetailsDTO.setSubsid(subsDetailsVO.getSubsid());
        subsDetailsDTO.setSubsName(subsDetailsVO.getSubsName());
        subsDetailsDTO.setTimePeriod(subsDetailsVO.getTimePeriod());
        subsDetailsDTO.setStatus(subsDetailsVO.getStatus());
        return subsDetailsDTO;
    }

    /**
     * Cart transfer.
     * 
     * @param cartDTO
     *            the cart dto
     * @param cartVO
     *            the cart vo
     * @return the user cart vo
     */
    public static UserBookShelfVO cartTransfer(UserBookShelfDTO cartDTO, UserBookShelfVO cartVO) {
        BooksDTO booksDTO = cartDTO.getBooksDTO();
        UserDTO userDTO = cartDTO.getUserDTO();
        BooksVO booksVO = new BooksVO();
        UserValueObject userValueObject = new UserValueObject();
        booksVO = ServiceHelper.booksDetailsTransfer(booksDTO, booksVO);
        userValueObject = ServiceHelper
                .objectTransfer(userValueObject, userDTO);
        cartVO.setBooksVO(booksVO);
        cartVO.setUserVO(userValueObject);
        return cartVO;
    }

    /**
     * Cart details transfer dao to service.
     * 
     * @param booksInCartDTO
     *            the books in cart dto
     * @param booksInCartVO
     *            the books in cart vo
     * @return the list
     */
    public static List<UserBookShelfVO> cartDetailsTransferDaoToService(
            List<UserBookShelfDTO> booksInCartDTO, List<UserBookShelfVO> booksInCartVO) {
        Iterator<UserBookShelfDTO> it = booksInCartDTO.iterator();
        while (it.hasNext()) {
            UserBookShelfVO cartVO = new UserBookShelfVO();
            UserBookShelfDTO cartDTO = (UserBookShelfDTO) it.next();
            cartVO = ServiceHelper.cartTransfer(cartDTO, cartVO);
            booksInCartVO.add(cartVO);
        }
        return booksInCartVO;

    }

    /**
     * Request transfer service to dao.
     * 
     * @param requestVO
     *            the request vo
     * @param requestDTO
     *            the request dto
     * @return the request book dto
     */
    public static RequestBookDTO requestTransferServiceToDao(
            RequestBookVO requestVO, RequestBookDTO requestDTO) {

        UserDTO userDTO = new UserDTO();
        BooksDTO booksDTO = new BooksDTO();

        UserValueObject userValueObject = requestVO.getUserVO();
        userDTO = ServiceHelper.serviceToDaoTransfer(userValueObject, userDTO);

        BooksVO booksVO = requestVO.getBooksVO();
        booksDTO = ServiceHelper.booksTranfer(booksVO, booksDTO);
        
        requestDTO.setBooksDTO(booksDTO);
        requestDTO.setUserDTO(userDTO);
        requestDTO.setAddress(requestVO.getAddress());
        requestDTO.setCancellationDate(requestVO.getCancellationDate());
        requestDTO.setRequestDate(requestVO.getRequestDate());
        requestDTO.setRequestId(requestVO.getRequestId());
        requestDTO.setRequestStatus(requestVO.getRequestStatus());
        requestDTO.setReturnDate(requestVO.getReturnDate());

        return requestDTO;

    }

    /**
     * Request transfer dao to service.
     * 
     * @param requestDTO
     *            the request dto
     * @param requestVO
     *            the request vo
     * @return the request book vo
     */
    public static RequestBookVO requestTransferDaoToService(RequestBookDTO requestDTO, RequestBookVO requestVO) {
      
        BooksDTO booksDTO = requestDTO.getBooksDTO();
        UserDTO userDTO = requestDTO.getUserDTO();
       
        BooksVO booksVO = new BooksVO();
      
        UserValueObject userValueObject = new UserValueObject();
      
        booksVO = ServiceHelper.booksDetailsTransfer(booksDTO, booksVO);
       
        userValueObject =ServiceHelper.objectTransfer(userValueObject, userDTO);
        requestVO.setBooksVO(booksVO);
        requestVO.setUserVO(userValueObject);
   
        requestVO.setEmaild(userValueObject.getEmaild());
        
        requestVO.setBookTitle(booksVO.getBookTitle());
       
        requestVO.setBookId(booksVO.getBookId());
      
        requestVO.setRequestDate(requestDTO.getRequestDate());
      
        requestVO.setReturnDate(requestDTO.getReturnDate());
        
        requestVO.setRequestStatus(requestDTO.getRequestStatus());
      
        requestVO.setAddress(requestDTO.getAddress());
      
        requestVO.setRequestId(requestDTO.getRequestId());
       
        requestVO.setCancellationDate(requestDTO.getCancellationDate());
      
        return requestVO;

    }

    /**
     * Requested books list transfer service to dao.
     * 
     * @param requestedBooksListVO
     *            the requested books list vo
     * @param requestedBooksListDTO
     *            the requested books list dto
     * @return the list
     */
    public static List<RequestBookVO> requestedBooksListTransferServiceToDao(List<RequestBookVO> requestedBooksListVO,List<RequestBookDTO> requestedBooksListDTO) {
          
        Iterator<RequestBookDTO> it = requestedBooksListDTO.iterator();
        
        while (it.hasNext()) {
        
            RequestBookVO requestVO = new RequestBookVO();
            
            RequestBookDTO requestDTO =(RequestBookDTO) it.next();
            
            requestVO = ServiceHelper.requestTransferDaoToService(requestDTO,requestVO);
           
            requestedBooksListVO.add(requestVO);
            
        }

        return requestedBooksListVO;

    }

    /**
     * Users subs details transfer.
     * 
     * @param usersListDTO
     *            the users list dto
     * @param usersListVO
     *            the users list vo
     * @return the list
     */
    public static List<UserSubsVO> usersSubsDetailsTransfer(List<UserSubsDTO> usersListDTO, List<UserSubsVO> usersListVO) {

        Iterator<UserSubsDTO> it = usersListDTO.iterator();
        while (it.hasNext()) {
            UserSubsVO userSubsVO = new UserSubsVO();
            UserSubsDTO userSubsDTO = it.next();
            userSubsVO=userSubsPlanDetailsTransfer(userSubsVO, userSubsDTO);
            usersListVO.add(userSubsVO);
        }
        return usersListVO;

    }
    
    public static UserSubsVO userSubsPlanDetailsTransfer(UserSubsVO userSubsVO,UserSubsDTO userSubsDTO){
        userSubsVO.setEmaild(userSubsDTO.getEmaild());
        userSubsVO.setAmount(userSubsDTO.getAmmount());
        userSubsVO.setMaxBooks(userSubsDTO.getMaxBooks());
        userSubsVO.setStatus(userSubsDTO.getStatus());
        userSubsVO.setSubEnd(userSubsDTO.getSubEnd());
        userSubsVO.setSubStart(userSubsDTO.getSubStart());
        userSubsVO.setSubsid(userSubsDTO.getSubsid());
        userSubsVO.setSubsName(userSubsDTO.getSubsName());
        userSubsVO.setTimePeriod(userSubsDTO.getTimePeriod());
        return userSubsVO;
    }

}
