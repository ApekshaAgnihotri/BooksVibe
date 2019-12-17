package com.booksVibe.models;

// TODO: Auto-generated Javadoc
/**
 * The Class UserCartBean.
 */
public class UserBookShelfBean {

    /** The user bean. */
    private UserBean userBean;

    /** The books bean. */
    private BooksBean booksBean;

    /** The cart id. */
    private int cartId;

    /**
     * Gets the user bean.
     * 
     * @return the user bean
     */
    public UserBean getUserBean() {
        return userBean;
    }

    /**
     * Sets the user bean.
     * 
     * @param userBean
     *            the new user bean
     */
    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    /**
     * Gets the books bean.
     * 
     * @return the books bean
     */
    public BooksBean getBooksBean() {
        return booksBean;
    }

    /**
     * Sets the books bean.
     * 
     * @param booksBean
     *            the new books bean
     */
    public void setBooksBean(BooksBean booksBean) {
        this.booksBean = booksBean;
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
