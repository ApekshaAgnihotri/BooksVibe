package com.booksVibe.service.valueObject;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksVO.
 */
public class BooksVO {

    /** The operator. */
    private UserValueObject operator;
    
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

    /** The newcopies. */
    private int copies, newcopies;

    /** The language. */
    private String language;

    /** The image file name. */
    private String imageFileName;

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
    public UserValueObject getOperator() {
        return operator;
    }

    /**
     * Sets the operator.
     *
     * @param operator the new operator
     */
    public void setOperator(UserValueObject operator) {
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
