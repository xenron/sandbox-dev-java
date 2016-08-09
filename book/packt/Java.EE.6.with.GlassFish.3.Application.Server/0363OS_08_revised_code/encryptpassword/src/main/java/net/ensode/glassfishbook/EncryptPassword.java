package net.ensode.glassfishbook;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPassword {

  public static String encryptPassword(String password)
      throws NoSuchAlgorithmException {
    MessageDigest messageDigest =
        MessageDigest.getInstance("MD5");
    byte[] bs;

    messageDigest.reset();
    bs = messageDigest.digest(password.getBytes());

    StringBuilder stringBuilder = new StringBuilder();

    //hex encode the digest
    for (int i = 0; i < bs.length; i++) {
      String hexVal = Integer.toHexString(0xFF & bs[i]);
      if (hexVal.length() == 1) {
        stringBuilder.append("0");
      }
      stringBuilder.append(hexVal);
    }

    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    String encryptedPassword = null;

    try {

      if (args.length == 0) {
        System.err.println("Usage: java "
            + "net.ensode.glassfishbook.EncryptPassword "
            + "cleartext");
      } else {
        encryptedPassword = encryptPassword(args[0]);
        System.out.println(encryptedPassword);
      }
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }
}
