package com.booksVibe.dao.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class RecommendBooksDTO.
 */
@Entity
@Table(name = "Recommend_books")
public class RecommendBooksDTO {

    /** The user dto. */
    @ManyToOne
    private UserDTO userDTO;

    /** The books dto. */
    @ManyToOne
    private BooksDTO booksDTO;

    /** The id. */
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;

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
