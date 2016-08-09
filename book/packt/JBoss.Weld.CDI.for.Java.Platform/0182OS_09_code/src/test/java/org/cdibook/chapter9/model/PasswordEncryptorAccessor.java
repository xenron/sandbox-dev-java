package org.cdibook.chapter9.model;

public class PasswordEncryptorAccessor {

    public static boolean matches(String password, String hashed) {
        return User.PasswordEncryptor.matches(password, hashed);
    }
}
