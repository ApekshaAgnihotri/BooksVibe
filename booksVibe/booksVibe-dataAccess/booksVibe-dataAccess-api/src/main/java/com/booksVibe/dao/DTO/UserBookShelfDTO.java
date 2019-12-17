package com.booksVibe.dao.DTO;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class UserCartDTO.
 */
@Entity
@Table(name = "user_book_shelf")
public class UserBookShelfDTO {

    /** The user dto. */
    @ManyToOne
    private UserDTO userDTO;

    /** The books dto. */
    @ManyToOne
    private BooksDTO booksDTO;

    /** The cart id. */
    @Id
    @GeneratedValue
    private int shelfId;

    /**
     * Gets the user dto.
     * 
     * @return the user dto
     */
    public UserDTO getUserDTO() {
        return userDTO;
    }

    /**
     * Sets the user dto.
     * 
     * @param userDTO
     *            the new user dto
     */
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    /**
     * Gets the books dto.
     * 
     * @return the books dto
     */
    public BooksDTO getBooksDTO() {
        return booksDTO;
    }

    /**
     * Sets the books dto.
     * 
     * @param booksDTO
     *            the new books dto
     */
    public void setBooksDTO(BooksDTO booksDTO) {
        this.booksDTO = booksDTO;
    }

    /**
     * Gets the cart id.
     * 
     * @return the cart id
     */
    public int getCartId() {
        return shelfId;
    }

    /**
     * Sets the cart id.
     * 
     * @param cartId
     *            the new cart id
     */
    public void setCartId(int cartId) {
        this.shelfId = cartId;
    }

}
