package day05;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tjen on 05/12/16.
 */
public class MD5 {
    public static String hash(String input) {
        final MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md5.update(input.getBytes());
        final byte[] digest = md5.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
    
}
