package org.cdibook.chapter9.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PasswordEncryptorTest {

    @Test
    public void testEncryption() {
        String pwd = "testing";

        String encrypted = User.PasswordEncryptor.encrypt(pwd);

        Assert.assertFalse(pwd.equals(encrypted));
    }

    @Test
    public void testComparison() {
        String pwd = "testing";

        String encrypted = User.PasswordEncryptor.encrypt(pwd);

        Assert.assertFalse(pwd.equals(encrypted));
        Assert.assertTrue(User.PasswordEncryptor.matches(pwd, encrypted));
    }

    @Test
    public void testComparison2() {
        String pwd = "testing";

        String encrypted = User.PasswordEncryptor.encrypt(pwd);

        Assert.assertFalse(pwd.equals(encrypted));
        Assert.assertFalse(User.PasswordEncryptor.matches("testing1", encrypted));
        Assert.assertFalse(User.PasswordEncryptor.matches("testinf", encrypted));
        Assert.assertFalse(User.PasswordEncryptor.matches("testin", encrypted));
    }
}
