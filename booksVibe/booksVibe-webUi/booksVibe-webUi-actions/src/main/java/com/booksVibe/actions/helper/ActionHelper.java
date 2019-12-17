package com.booksVibe.actions.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.booksVibe.models.BooksBean;
import com.booksVibe.models.RequestBookBean;
import com.booksVibe.models.SubsDetailsBean;
import com.booksVibe.models.UserBean;
import com.booksVibe.models.UserBookShelfBean;
import com.booksVibe.models.UserSubsBean;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.RequestBookVO;
import com.booksVibe.service.valueObject.SubsDetailsVO;
import com.booksVibe.service.valueObject.UserBookShelfVO;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.service.valueObject.UserValueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionHelper.
 * This class perform data transfers between the objects.
 */
public final class ActionHelper {

    private ActionHelper(){
        
    }
    /**
     * Object transfer.
     * 
     * @param userBean
     *            the user bean
     * @param userValueObject
     *            the user value object
     * @return the user bean
     */
    public static UserBean objectTransfer(UserBean userBean,
            UserValueObject userValueObject) {

        userBean.setFirstname(userValueObject.getFirstname());
        userBean.setLastname(userValueObject.getLastname());
        userBean.setEmaild(userValueObject.getEmaild());
        userBean.setPassword(userValueObject.getPassword());
        userBean.setLanguage(userValueObject.getLanguage());
        userBean.setAddress(userValueObject.getAddress());
        userBean.setSubsid(userValueObject.getSubsid());
        userBean.setContactno(userValueObject.getContactno());
        userBean.setRole(userValueObject.getRole());
        return userBean;
    }

    /**
     * Action to service transfer.
     * 
     * @param userBean
     *            the user bean
     * @param userValueObject
     *            the user value object
     * @return the user value object
     */
    public static UserValueObject actionToServiceTransfer(UserBean userBean,
            UserValueObject userValueObject) {

        userValueObject.setAddress(userBean.getAddress());
        userValueObject.setContactno(userBean.getContactno());
        userValueObject.setEmaild(userBean.getEmaild());
        userValueObject.setFirstname(userBean.getFirstname());
        userValueObject.setLanguage(userBean.getLanguage());
        userValueObject.setLastname(userBean.getLastname());
        userValueObject.setPassword(userBean.getPassword());
        userValueObject.setSubsid(userBean.getSubsid());
        userValueObject.setRole(userBean.getRole());
        return userValueObject;
    }

    /**
     * Subs details transfer.
     * from service layer to action layer
     * @param subsDetailsVO
     *            the subs details vo
     * @param subsDetailsBean
     *            the subs details bean
     * @return the subs details bean
     */
    public static SubsDetailsBean subsDetailsTransfer(
            SubsDetailsVO subsDetailsVO, SubsDetailsBean subsDetailsBean) {

        subsDetailsBean.setAmount(subsDetailsVO.getAmount());
        subsDetailsBean.setMaxBooks(subsDetailsVO.getMaxBooks());
        subsDetailsBean.setSubsid(subsDetailsVO.getSubsid());
        subsDetailsBean.setSubsName(subsDetailsVO.getSubsName());
        subsDetailsBean.setTimePeriod(subsDetailsVO.getTimePeriod());
        return subsDetailsBean;

    }

    /**
     * Books transfer.
     * from action layer to service layer
     * @param booksVO
     *            the books vo
     * @param booksBean
     *            the books bean
     * @return the books vo
     */
    public static BooksVO booksTransfer(BooksVO booksVO, BooksBean booksBean) {

        booksVO.setAuthor(booksBean.getAuthor());
        booksVO.setBookId(booksBean.getBookId());
        booksVO.setBookTitle(booksBean.getBookTitle());
        booksVO.setCategory(booksBean.getCategory());
        booksVO.setPublisher(booksBean.getPublisher());
        booksVO.setCopies(booksBean.getCopies());
        booksVO.setLanguage(booksBean.getLanguage());
        booksVO.setNewcopies(booksBean.getNewcopies());
        booksVO.setImageFileName(booksBean.getKimageFileName());
        booksVO.setAvailability(booksBean.getAvailability());

        return booksVO;

    }

    /**
     * Books details transfer.
     * from service layer to action layer
     * @param booksVO
     *            the books vo
     * @param booksBean
     *            the books bean
     * @return the books bean
     */
    public static BooksBean booksDetailsTransfer(BooksVO booksVO,BooksBean booksBean) 
    {
        booksBean.setAuthor(booksVO.getAuthor());
        booksBean.setBookId(booksVO.getBookId());
        booksBean.setBookTitle(booksVO.getBookTitle());
        booksBean.setCategory(booksVO.getCategory());
        booksBean.setCopies(booksVO.getCopies());
        booksBean.setLanguage(booksVO.getLanguage());
        booksBean.setPublisher(booksVO.getPublisher());
        booksBean.setKimageFileName("../images/" + booksVO.getImageFileName());
        booksBean.setAvailability(booksVO.getAvailability());
        booksBean.setInShelf(booksVO.getInShelf());
        booksBean.setIsRequested(booksVO.getIsRequested());
        return booksBean;
    }

    /**
     * Books list transfer.
     * This method transfers list from service layer to action layer
     * @param booksListVO
     *            the books list vo
     * @param booksListBean
     *            the books list bean
     * @return the list
     */
    public static List<BooksBean> booksListTransfer(List<BooksVO> booksListVO,
            List<BooksBean> booksListBean) {
        Iterator<BooksVO> it = booksListVO.iterator();
        while (it.hasNext()) {
            BooksBean booksBean = new BooksBean();
            BooksVO booksVO = (BooksVO) it.next();
            booksBean = ActionHelper.booksDetailsTransfer(booksVO, booksBean);
            booksListBean.add(booksBean);
        }
        return booksListBean;
    }

    /**
     * Subscription list transfer.
     * This method transfers subscription plans list form action to service layer.
     * 
     * @param subsListBean
     *            the subs list bean
     * @param subsListVO
     *            the subs list vo
     * @return the list
     */
    public static List<SubsDetailsVO> subsListTransfer(
            List<SubsDetailsBean> subsListBean, List<SubsDetailsVO> subsListVO) {
        Iterator<SubsDetailsBean> it = subsListBean.iterator();
        while (it.hasNext()) {
            SubsDetailsVO subsDetailsVO = new SubsDetailsVO();
            SubsDetailsBean subsDetailsBean = it.next();
            subsDetailsVO = ActionHelper.subsDetailBeanToVO(subsDetailsBean,
                    subsDetailsVO);
            subsListVO.add(subsDetailsVO);
        }

        return subsListVO;
    }

    /**
     * Subscription details bean to vo.
     * This method transfers subscription details object data from action layer
     * to service layer.
     * @param subsDetailsBean
     *            the subs details bean
     * @param subsDetailsVO
     *            the subs details vo
     * @return the subs details vo
     */
    public static SubsDetailsVO subsDetailBeanToVO(
            SubsDetailsBean subsDetailsBean, SubsDetailsVO subsDetailsVO) {
        subsDetailsVO.setAmount(subsDetailsBean.getAmount());
        subsDetailsVO.setMaxBooks(subsDetailsBean.getMaxBooks());
        subsDetailsVO.setSubsid(subsDetailsBean.getSubsid());
        subsDetailsVO.setSubsName(subsDetailsBean.getSubsName());
        subsDetailsVO.setTimePeriod(subsDetailsBean.getTimePeriod());
        subsDetailsVO.setStatus(subsDetailsBean.getStatus());
        return subsDetailsVO;
    }

    /**
     * user book shelf transfer.
     * This method transfer shelf object data from service layer to action layer.
     * @param cartBean
     *            the cart bean
     * @param cartVO
     *            the cart vo
     * @return the user cart bean
     */
    public static UserBookShelfBean cartTransfer(UserBookShelfBean cartBean,
            UserBookShelfVO cartVO) {

        UserValueObject userValueObject = cartVO.getUserVO();
        BooksVO booksVO = cartVO.getBooksVO();
        UserBean userBean = new UserBean();
        BooksBean booksBean = new BooksBean();
        userBean = ActionHelper.objectTransfer(userBean, userValueObject);
        booksBean = ActionHelper.booksDetailsTransfer(booksVO, booksBean);
        cartBean.setBooksBean(booksBean);
        cartBean.setUserBean(userBean);

        return cartBean;

    }

    /**
     * Shelf details transfer service to action.
     * This method transfers user shelf's data list from service layer to action layer. 
     * @param booksInCartVO
     *            the books in cart vo
     * @param booksInCartBean
     *            the books in cart bean
     * @return the list
     */
    public static List<UserBookShelfBean> cartDetailsTransferServiceToAction(
            List<UserBookShelfVO> booksInCartVO,
            List<UserBookShelfBean> booksInCartBean) {
        Iterator<UserBookShelfVO> it = booksInCartVO.iterator();
        while (it.hasNext()) {
            UserBookShelfBean cartBean = new UserBookShelfBean();
            UserBookShelfVO cartVO = (UserBookShelfVO) it.next();
            cartBean = ActionHelper.cartTransfer(cartBean, cartVO);
            booksInCartBean.add(cartBean);
        }

        return booksInCartBean;

    }

    /**
     * Books list in user shelf.
     * This method transfers user shelf's data list from service layer to action layer
     * @param booksInCartBean
     *            the books in cart bean
     * @return the list
     */
    public static List<BooksBean> booksInCartList(
            List<UserBookShelfBean> booksInCartBean) {
        List<BooksBean> booksInCartList = new ArrayList<BooksBean>();
        Iterator<UserBookShelfBean> it = booksInCartBean.iterator();
        while (it.hasNext()) {
            UserBookShelfBean cartBean = (UserBookShelfBean) it.next();
            BooksBean booksBean = cartBean.getBooksBean();
            booksInCartList.add(booksBean);
        }
        return booksInCartList;
    }

    /**
     * Request objects transfer.
     * This method transfers users requests information from service layer to action layer
     * @param requestBean
     *            the request bean
     * @param requestVO
     *            the request vo
     * @return the request book bean
     */
    public static RequestBookBean requestObjectsTransfer(
            RequestBookBean requestBean, RequestBookVO requestVO) {

        UserValueObject userValueObject = requestVO.getUserVO();
        BooksVO booksVO = requestVO.getBooksVO();
        UserBean userBean = new UserBean();
        BooksBean booksBean = new BooksBean();
        userBean = ActionHelper.objectTransfer(userBean, userValueObject);
        booksBean = ActionHelper.booksDetailsTransfer(booksVO, booksBean);
        requestBean.setBooksBean(booksBean);
        requestBean.setUserBean(userBean);
        requestBean.setEmaild(userBean.getEmaild());
        requestBean.setBookTitle(booksBean.getBookTitle());
        requestBean.setBookId(booksBean.getBookId());
        requestBean.setAuthor(booksBean.getAuthor());
        requestBean.setRequestDate(requestVO.getRequestDate());
        requestBean.setRequestStatus(requestVO.getRequestStatus());
        requestBean.setReturnDate(requestVO.getReturnDate());
        requestBean.setRequestId(requestVO.getRequestId());
        requestBean.setAddress(requestVO.getAddress());
        requestBean.setCancellationDate(requestVO.getCancellationDate());

        return requestBean;

    }

    /**
     * Requested books list transfer service to action.
     * 
     * @param requestedBookListVO
     *            the requested book list vo
     * @param requestedBooksListBean
     *            the requested books list bean
     * @return the list
     */
    public static List<RequestBookBean> requestedBooksListTransferServiceToAction(
            List<RequestBookVO> requestedBookListVO,
            List<RequestBookBean> requestedBooksListBean) {
        Iterator<RequestBookVO> it = requestedBookListVO.iterator();
        while (it.hasNext()) {
            RequestBookBean requestBean = new RequestBookBean();
            RequestBookVO requestVO = (RequestBookVO) it.next();
            requestBean = ActionHelper.requestObjectsTransfer(requestBean,
                    requestVO);
            requestedBooksListBean.add(requestBean);
        }
        return requestedBooksListBean;

    }

    /**
     * Requested books list transfer.
     * This method transfers requested book list from service to action layer.
     * @param requestedBooksListBean
     *            the requested books list bean
     * @return the list
     */
    public static List<BooksBean> requestedBooksListTransfer(
            List<RequestBookBean> requestedBooksListBean) {

        List<BooksBean> requestedBooksList = new ArrayList<BooksBean>();
        Iterator<RequestBookBean> it = requestedBooksListBean.iterator();
        while (it.hasNext()) {
            RequestBookBean requestBean = (RequestBookBean) it.next();
            BooksBean booksBean = requestBean.getBooksBean();
            requestedBooksList.add(booksBean);
        }
        return requestedBooksList;
    }

    /**
     * Users subscription details transfer.
     * This method transfers user subscription details from service layer to action
     * layer.
     * 
     * @param usersListVO
     *            the users list vo
     * @param usersListBean
     *            the users list bean
     * @return the list
     */
    public static List<UserSubsBean> usersSubsDetailsTransfer(
            List<UserSubsVO> usersListVO, List<UserSubsBean> usersListBean) {
        Iterator<UserSubsVO> it = usersListVO.iterator();
        while (it.hasNext()) {
            UserSubsBean userSubsBean = new UserSubsBean();
            UserSubsVO userSubsVO = it.next();
            userSubsBean.setEmaild(userSubsVO.getEmaild());
            userSubsBean.setMaxBooks(userSubsVO.getMaxBooks());
            userSubsBean.setStatus(userSubsVO.getStatus());
            userSubsBean.setSubEnd(userSubsVO.getSubEnd());
            userSubsBean.setSubsid(userSubsVO.getSubsid());
            userSubsBean.setSubsName(userSubsVO.getSubsName());
            userSubsBean.setSubStart(userSubsVO.getSubStart());
            userSubsBean.setTimePeriod(userSubsVO.getTimePeriod());
            userSubsBean.setAmount(userSubsVO.getAmount());
            usersListBean.add(userSubsBean);
        }
        return usersListBean;
    }

}
