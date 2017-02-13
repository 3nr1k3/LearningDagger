package com.ecardero.learningdagger.helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ecardero on 3/02/17.
 */

public class Md5Helper {
    public static String hash(String publicApiKey, String privateApiKey, String timestamp) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String toHash = timestamp + privateApiKey + publicApiKey;
            return new BigInteger(1, md.digest(toHash.getBytes())).toString(16);
        } catch (NoSuchAlgorithmException e) {
        }

        return null;
    }
}
