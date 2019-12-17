package com.booksVibe.dao.DTO;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDTO.
 */
@Entity
@Table(name = "user")
public class UserDTO {

    /** The emaild. */
    @Id
    @Column(name = "email_id")
    private String emaild;

    /** The firstname. */
    @Column(name = "first_name")
    private String firstname;

    /** The lastname. */
    @Column(name = "last_name")
    private String lastname;

    /** The password. */
    private String password;

    /** The address. */
    private String address;

    /** The contactno. */
    @Column(name = "contact_no")
    private String contactno;

    /** The language. */
    private String language;

    /** The role. */
    private String role;

    /** The subsid. */
    private int subsid;

    /** The requests. */
    @Transient
    private int requests;
  
     
    /**
     * Gets the requests.
     *
     * @return the requests
     */
    public int getRequests() {
        return requests;
    }

    /**
     * Sets the requests.
     *
     * @param requests the new requests
     */
    public void setRequests(int requests) {
        this.requests = requests;
    }

    /**
     * Gets the role.
     * 
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role.
     * 
     * @param role
     *            the new role
     */
    public void setRole(String role) {
        this.role = role;
    }

  
  
    /**
     * Gets the firstname.
     * 
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the firstname.
     * 
     * @param firstname
     *            the new firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the lastname.
     * 
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the lastname.
     * 
     * @param lastname
     *            the new lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * 
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the emaild.
     * 
     * @return the emaild
     */
    public String getEmaild() {
        return emaild;
    }

    /**
     * Sets the emaild.
     * 
     * @param emaild
     *            the new emaild
     */
    public void setEmaild(String emaild) {
        this.emaild = emaild;
    }

    /**
     * Gets the address.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * 
     * @param address
     *            the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the contactno.
     * 
     * @return the contactno
     */
    public String getContactno() {
        return contactno;
    }

    /**
     * Sets the contactno.
     * 
     * @param contactno
     *            the new contactno
     */
    public void setContactno(String contactno) {
        this.contactno = contactno;
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
     * Gets the subsid.
     * 
     * @return the subsid
     */
    public int getSubsid() {
        return subsid;
    }

    /**
     * Sets the subsid.
     * 
     * @param subsid
     *            the new subsid
     */
    public void setSubsid(int subsid) {
        this.subsid = subsid;
    }

}
