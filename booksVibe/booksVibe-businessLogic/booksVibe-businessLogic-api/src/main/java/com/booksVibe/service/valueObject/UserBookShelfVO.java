package com.booksVibe.service.valueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class UserCartVO.
 */
public class UserBookShelfVO {

    /** The user vo. */
    private UserValueObject userVO;

    /** The books vo. */
    private BooksVO booksVO;

    /** The cart id. */
    private int cartId;

    /**
     * Gets the user vo.
     * 
     * @return the user vo
     */
    public UserValueObject getUserVO() {
        return userVO;
    }

    /**
     * Sets the user vo.
     * 
     * @param userVO
     *            the new user vo
     */
    public void setUserVO(UserValueObject userVO) {
        this.userVO = userVO;
    }

    /**
     * Gets the books vo.
     * 
     * @return the books vo
     */
    public BooksVO getBooksVO() {
        return booksVO;
    }

    /**
     * Sets the books vo.
     * 
     * @param booksVO
     *            the new books vo
     */
    public void setBooksVO(BooksVO booksVO) {
        this.booksVO = booksVO;
    }

    /**
     * Gets the cart id.
     * 
     * @return the cart id
     */
    public int getCartId() {
        return cartId;
    }

    /**
     * Sets the cart id.
     * 
     * @param cartId
     *            the new cart id
     */
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

}
