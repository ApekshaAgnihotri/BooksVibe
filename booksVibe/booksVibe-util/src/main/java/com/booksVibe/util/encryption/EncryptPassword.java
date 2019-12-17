package com.booksVibe.util.encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.booksVibe.util.exception.UtilException;


// TODO: Auto-generated Javadoc
/**
 * The Class EncryptPassword.
 */
public final class EncryptPassword {

    /** The Constant SIZE. */
    private static final int SIZE = 16;

    /**
     * Instantiates a new encrypt password.
     */
    private EncryptPassword() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Md5.
     *
     * @param password the password
     * @return the string
     * @throws UtilException the util exception
     */
    public static String md5(String password) throws UtilException {

        String md5 = null;

        try {

            // Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");

            // Update input string in message digest
            digest.update(password.getBytes(), 0, password.length());

            // Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest()).toString(SIZE);

            return md5;

        } catch (NoSuchAlgorithmException e) {
            throw new UtilException(e);
        }

    }

}
