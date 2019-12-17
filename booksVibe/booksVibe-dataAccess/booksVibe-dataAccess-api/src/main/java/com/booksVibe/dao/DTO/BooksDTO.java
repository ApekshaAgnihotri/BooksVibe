package com.booksVibe.dao.DTO;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksDTO.
 */
@Entity
@Table(name = "books")
public class BooksDTO {

    /** The operator. */
    @ManyToOne
    @JoinColumn(name="Operator_Id")
    private UserDTO operator;
    
    /** The book title. */
    @Column(name = "title")
    private String bookTitle;

    /** The book id. */
    @Id
    @Column(name = "book_id")
    @GeneratedValue
    private int bookId;

    /** The author. */
    private String author;

    /** The category. */
    private String category;

    /** The publisher. */
    private String publisher;

    /** The copies. */
    private int copies;

    /** The language. */
    private String language;

    /** The image file name. */
    @Column(name = "Image_File_Name")
    private String imageFileName;

    /** The availability. */
    private String availability;
    
    /** The in shelf. */
    @Transient
    private String inShelf;
   
    /** The is requested. */
    @Transient
    private String isRequested;
    
    
    



    /**
     * Gets the in shelf.
     *
     * @return the in shelf
     */
    public String getInShelf() {
        return inShelf;
    }


    /**
     * Sets the in shelf.
     *
     * @param inShelf the new in shelf
     */
    public void setInShelf(String inShelf) {
        this.inShelf = inShelf;
    }


    /**
     * Gets the checks if is requested.
     *
     * @return the checks if is requested
     */
    public String getIsRequested() {
        return isRequested;
    }


    /**
     * Sets the checks if is requested.
     *
     * @param isRequested the new checks if is requested
     */
    public void setIsRequested(String isRequested) {
        this.isRequested = isRequested;
    }


    /**
     * Gets the operator.
     *
     * @return the operator
     */
    public UserDTO getOperator() {
        return operator;
    }


    /**
     * Sets the operator.
     *
     * @param operator the new operator
     */
    public void setOperator(UserDTO operator) {
        this.operator = operator;
    }


    /**
     * Gets the availability.
     * 
     * @return the availability
     */
    public String getAvailability() {
        return availability;
    }

 
    /**
     * Sets the availability.
     * 
     * @param availability
     *            the new availability
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     * Gets the image file name.
     * 
     * @return the image file name
     */
    public String getImageFileName() {
        return imageFileName;
    }

    /**
     * Sets the image file name.
     * 
     * @param imageFileName
     *            the new image file name
     */
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    /**
     * Gets the language.
     * 
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     * 
     * @param language
     *            the new language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets the book title.
     * 
     * @return the book title
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Sets the book title.
     * 
     * @param bookTitle
     *            the new book title
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * Gets the book id.
     * 
     * @return the book id
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Sets the book id.
     * 
     * @param bookId
     *            the new book id
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * Gets the author.
     * 
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     * 
     * @param author
     *            the new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the category.
     * 
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category.
     * 
     * @param category
     *            the new category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the publisher.
     * 
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the publisher.
     * 
     * @param publisher
     *            the new publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets the copies.
     * 
     * @return the copies
     */
    public int getCopies() {
        return copies;
    }

    /**
     * Sets the copies.
     * 
     * @param copies
     *            the new copies
     */
    public void setCopies(int copies) {
        this.copies = copies;
    }

}
