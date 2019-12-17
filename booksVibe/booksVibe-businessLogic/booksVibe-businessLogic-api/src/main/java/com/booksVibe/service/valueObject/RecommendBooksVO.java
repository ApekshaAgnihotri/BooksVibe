package com.booksVibe.service.valueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class RecommendBooksVO.
 */
public class RecommendBooksVO {

    /** The user value object. */
    private UserValueObject userValueObject;

    /** The books vo. */
    private BooksVO booksVO;

    /** The id. */
    private int id;

    /**
     * Gets the user value object.
     * 
     * @return the user value object
     */
    public UserValueObject getUserValueObject() {
        return userValueObject;
    }

    /**
     * Sets the user value object.
     * 
     * @param userValueObject
     *            the new user value object
     */
    public void setUserValueObject(UserValueObject userValueObject) {
        this.userValueObject = userValueObject;
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
     * Gets the id.
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id
     *            the new id
     */
    public void setId(int id) {
        this.id = id;
    }

}
