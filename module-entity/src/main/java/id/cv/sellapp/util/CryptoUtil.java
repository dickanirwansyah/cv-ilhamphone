package id.cv.sellapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoUtil {

    private static final Logger log = LoggerFactory.getLogger(CryptoUtil.class);

    private static String md5(final String input) throws NoSuchAlgorithmException {
        final MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] messageDigests = md.digest(input.getBytes());
        final BigInteger number = new BigInteger(1, messageDigests);
        return String.format("%032x", number);
    }

    private static Cipher initCipher (final int mode, final String initialVectorString, final String secretKey)
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {

        final SecretKeySpec secretKeySpec = new SecretKeySpec(md5(secretKey).getBytes(), "AES");
        final IvParameterSpec initialVector = new IvParameterSpec(initialVectorString.getBytes());
        final Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
        cipher.init(mode, secretKeySpec, initialVector);
        return cipher;
    }

    public String encrypted(final String dataToEncrypt, final String initialVector, final String secretKey){
        try{
            String encryptedData = null;
            final Cipher cipher = initCipher(Cipher.ENCRYPT_MODE, initialVector, secretKey);
            final byte[] encryptByteArray = cipher.doFinal(dataToEncrypt.getBytes());
            //encode using base64
            encryptedData = (new BASE64Encoder()).encode(encryptByteArray);
            return encryptedData;
        }catch (Exception e){
            if (log.isInfoEnabled()){
                log.debug("{\"error\" : \"error because " +e.getMessage()+" \"}");
            }
            throw new RuntimeException("error "+e.getMessage());
        }
    }

    public String decrypted(final String dataToDecrypt, final String initialVector, final String secretKey){
        try{
            String decryptedData = null;
            final Cipher cipher = initCipher(Cipher.DECRYPT_MODE, initialVector, secretKey);
            //decode using base64
            final byte[] dataDecrypByteArray = (new BASE64Decoder().decodeBuffer(dataToDecrypt));
            final byte[] decrypteArray = cipher.doFinal(dataDecrypByteArray);
            decryptedData = new String(decrypteArray, "UTF8");
            return decryptedData;
        }catch (Exception e){
            if (log.isInfoEnabled()){
                log.debug("{\"error\" : \"error because  "+e.getMessage()+" \"}");
            }
            throw new RuntimeException("error "+e.getMessage());
        }
    }

}
