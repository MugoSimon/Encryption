package lastie_wangechian_Encryption.com;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Encryption {

    String input;

    public Encryption(String input) {
        this.input = input;
    }

    public String getEncryption() {

        try {

            MessageDigest md5d = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md5d.digest(input.getBytes());
            BigInteger number = new BigInteger(1,messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32){

                hashtext = "0" + hashtext;
            }
            return hashtext;

        }catch (Exception e){

            //toast imekataa
        }

        return input;
    }


}
