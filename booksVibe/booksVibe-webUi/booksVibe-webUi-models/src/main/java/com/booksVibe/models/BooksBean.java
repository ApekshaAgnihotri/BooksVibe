package com.booksVibe.models;

import java.io.File;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksBean.
 */
public class BooksBean {

    /** The operator. */
    private UserBean operator;

    /** The book title. */
    private String bookTitle;

    /** The book id. */
    private int bookId;

    /** The author. */
    private String author;

    /** The category. */
    private String category;

    /** The publisher. */
    private String publisher;

    /** The copies. */
    private int copies;

    /** The newcopies. */
    private int newcopies;

    /** The language. */
    private String language;

    /** The kimage. */
    private File kimage;

    /** The kimage file name. */
    private String kimageFileName;

    /** The kimage content type. */
    private String kimageContentType;

    /** The availability. */
    private String availability;
    
    
    /** The in shelf. */
    private String inShelf;
    
    /** The is requested. */
    private String isRequested;

    
    public String getInShelf() {
        return inShelf;
    }

    public void setInShelf(String inShelf) {
        this.inShelf = inShelf;
    }

    public String getIsRequested() {
        return isRequested;
    }

    public void setIsRequested(String isRequested) {
        this.isRequested = isRequested;
    }

    /**
     * Gets the operator.
     *
     * @return the operator
     */
    public UserBean getOperator() {
        return operator;
    }

    /**
     * Sets the operator.
     *
     * @param operator the new operator
     */
    public void setOperator(UserBean operator) {
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
     * Gets the kimage.
     * 
     * @return the kimage
     */
    public File getKimage() {
        return kimage;
    }

    /**
     * Sets the kimage.
     * 
     * @param kimage
     *            the new kimage
     */
    public void setKimage(File kimage) {
        this.kimage = kimage;
    }

    /**
     * Gets the kimage file name.
     * 
     * @return the kimage file name
     */
    public String getKimageFileName() {
        return kimageFileName;
    }

    /**
     * Sets the kimage file name.
     * 
     * @param kimageFileName
     *            the new kimage file name
     */
    public void setKimageFileName(String kimageFileName) {
        this.kimageFileName = kimageFileName;
    }

    /**
     * Gets the kimage content type.
     * 
     * @return the kimage content type
     */
    public String getKimageContentType() {
        return kimageContentType;
    }

    /**
     * Sets the kimage content type.
     * 
     * @param kimageContentType
     *            the new kimage content type
     */
    public void setKimageContentType(String kimageContentType) {
        this.kimageContentType = kimageContentType;
    }

    /**
     * Gets the newcopies.
     * 
     * @return the newcopies
     */
    public int getNewcopies() {
        return newcopies;
    }

    /**
     * Sets the newcopies.
     * 
     * @param newcopies
     *            the new newcopies
     */
    public void setNewcopies(int newcopies) {
        this.newcopies = newcopies;
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
