package id.cv.sellapp.util;

public class TestCrypto {

    public static void main(String[] args){
        final CryptoUtil cryptoUtil = new CryptoUtil();
        final String IV = "0123456789123456";
        final String secretKey = "Mandiri1Pusat";
        final String encrypted = cryptoUtil.encrypted("muhammad dicka nirwansyah",
                IV, secretKey);
        final String descrypt = cryptoUtil.decrypted(encrypted, IV, secretKey);
        System.out.println("DATA ENCRYPT : "+encrypted);
        System.out.println("DATA DESCRYP : "+descrypt);
    }
}
