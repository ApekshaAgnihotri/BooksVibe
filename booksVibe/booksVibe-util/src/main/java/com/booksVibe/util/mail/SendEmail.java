package com.booksVibe.util.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.booksVibe.models.UserBean;
import com.booksVibe.service.valueObject.BooksVO;
import com.booksVibe.service.valueObject.UserSubsVO;
import com.booksVibe.util.exception.UtilException;

// TODO: Auto-generated Javadoc
/**
 * The Class sendEmail.
 */
public class SendEmail {

    private static final Logger LOGGER = Logger.getLogger(SendEmail.class);
    private static final String TRUE="true";
    /**
     * Request mail.
     * 
     * @param userBean
     *            contains user information
     * @param booksVO
     *            the books vo
     * @param requestType
     *            the requesttype
     * @throws UtilException
     */
    public void requestMail(UserBean userBean, BooksVO booksVO,
            String requestType) throws UtilException {

        LOGGER.info("SENDING MAIL TO" + userBean.getEmaild());
        final String username = "booksbuddy2014@gmail.com";
        final String password = "impetuscasestudy";

        Properties props = new Properties();
        props.put("mail.smtp.auth", TRUE);
        props.put("mail.smtp.starttls.enable", TRUE);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bibliotecastore@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(userBean.getEmaild()));
            if (requestType.equals("PendingRequest")) {
                message.setSubject("Request for Book");
                message.setText("Dear"
                        + userBean.getFirstname()
                        + ","
                        + "\n\n Your request for book "
                        + booksVO.getBookTitle()
                        + "is successfully submitted."
                        + "Book will be delieverd to you within 3 working days."
                        + "\nThank You for using BooksVibe..\n\nRegards,BooksVibe Team"
                        + "\n\n\n\n NOTE:  This message is computer generated.Kindly do not reply!!!");

            } else if (requestType.equals("return")) {
                message.setSubject("Return Request for Book");
                message.setText("Dear "
                        + userBean.getFirstname()
                        + ","
                        + "\n\n Your return request for book "
                        + booksVO.getBookTitle()
                        + "book is successfully submitted."
                        + "\n\n\nThank You for using BooksVibe..\n\nRegards,BooksVibe Team"
                        + "\n\n\n\nNOTE:This message is computer generated.Kindly do not reply!!!");

            } else if (requestType.equals("cancelDeleivery")) {
                message.setSubject("Cancellation");
                message.setText("Dear  "
                        + userBean.getFirstname()
                        + ","
                        + "\n\n Your request for book "
                        + booksVO.getBookTitle()
                        + "book is successfully cancelled."
                        + "\n\n\nThank You for using BooksVibe..\n\nRegards,BooksVibe Team"
                        + "\n\n\n\n NOTE :This message is computer generated.Kindly do not reply!!!");

            } else {
                message.setSubject("Cancellation");
                message.setText("Dear"
                        + userBean.getFirstname()
                        + ","
                        + "\n\n Your return request for book "
                        + booksVO.getBookTitle()
                        + "book is successfully cancelled."
                        + "\n\n\nThank You for using BooksVibe..\n\nRegards,BooksVibe Team"
                        + "\n\n\n\n NOTE : This message is computer generated.Kindly do not reply!!!");

            }
            Transport.send(message);

        } catch (MessagingException e) {
            throw new UtilException(e);
        }
        LOGGER.info("MAIL SENT");
    }

    /**
     * Request mail.
     * 
     * @param userSubsVO
     *            the user subs vo
     * @throws UtilException
     */
    public void requestMail(UserSubsVO userSubsVO) throws UtilException {
        LOGGER.info("SENDING MAIL");
        final String username = "bibliotecastore@gmail.com";
        final String password = "biblioteca123456";

        Properties props = new Properties();
        props.put("mail.smtp.auth", TRUE);
        props.put("mail.smtp.starttls.enable", TRUE);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("booksvibe@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(userSubsVO.getEmaild()));

            message.setSubject("Request for Book");
            message.setText("Dear User "
                    + ","
                    + "\n\n Your subscription plan  "
                    + userSubsVO.getSubsName()
                    + " is going to expire on."
                    + userSubsVO.getSubEnd()
                    + " date."
                    + "\n\nThank You for using BooksVibe..\n\nRegards,BooksVibe Team"
                    + "\n\n\n\n NOTE: This message is computer generated.Kindly do not reply!!!");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new UtilException(e);
        }
        LOGGER.info("MAIL SENT SUCCESSFULLY");
    }
}
