package org.cdibook.chapter9.model;

import org.apache.commons.codec.binary.Base64;
import org.cdibook.chapter9.enums.RoleType;
import org.cdibook.chapter9.exception.EncryptionOperationFailedException;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.Normalizer;
import java.util.Arrays;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends ParentObject {

    @Column(length = 80, nullable = false)
    @NotNull
    @Size(min = 3, max = 80)
    @Pattern(regexp = "[A-Za-z ]*")
    private String name;

    @Column(length = 250, nullable = false, unique = true)
    @NotNull
    @NotEmpty
    @Email
    private String email;

    @Column(name = "role", nullable = false)
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private RoleType role;

    @Column(name = "hashed_password", length = 256, nullable = false)
    @NotNull
    @NotEmpty
    private String hashedPassword;

    protected User() {
    }

    public User(String name, String email, RoleType role, String password) {
        this.name = name;
        this.email = email;
        this.role = role;
        if (null == password || password.length() < 5) {
            throw new IllegalArgumentException("Password must be greater than 5 characters in length");
        }
        this.hashedPassword = PasswordEncryptor.encrypt(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setPassword(String password) {
        this.hashedPassword = PasswordEncryptor.encrypt(password);
    }

    @Transient
    public boolean passwordMatches(String passwordToVerify) {
        if (null == this.getHashedPassword()) {
            return false;
        }

        return PasswordEncryptor.matches(passwordToVerify, this.getHashedPassword());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || !(obj instanceof User)) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        } else {
            User user = (User) obj;

            if (null != email ? !email.equals(user.email) : null != user.email) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + (null != email ? email.hashCode() : 0);
        return hash;
    }

    @Transient
    private static MessageDigest digester;

    final static class PasswordEncryptor {

        private static final int SALT_SIZE = 16;
        private static final int ITERATIONS = 10000;
        private static final String RESULT_CHARSET = "US-ASCII";

        public static String encrypt(String password) {
            try {
                final byte[] normalizedBytes = convertToBytes(password);

                // Create salt
                SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

                // Add salt before message
                byte[] salt = new byte[SALT_SIZE];
                random.nextBytes(salt);

                byte[] hash = digest(normalizedBytes, salt);
                hash = Base64.encodeBase64(hash);
                return new String(hash, RESULT_CHARSET);
            } catch (Exception e) {
                throw new EncryptionOperationFailedException();
            }
        }

        public static boolean matches(final String unencrypted, final String encrypted) {
            boolean matches = false;

            if (null != unencrypted) {
                try {
                    byte[] normalizedBytes = convertToBytes(unencrypted);

                    // Reverse encoding
                    byte[] encryptedBytes = encrypted.getBytes(RESULT_CHARSET);
                    encryptedBytes = Base64.decodeBase64(encryptedBytes);

                    // Extract salt
                    byte[] salt = new byte[SALT_SIZE];
                    System.arraycopy(encryptedBytes, 0, salt, 0, SALT_SIZE);

                    final byte[] hashed = digest(normalizedBytes, salt);

                    matches = Arrays.equals(hashed, encryptedBytes);
                } catch (Exception e) {
                    throw new EncryptionOperationFailedException();
                }
            }

            return matches;
        }

        private static byte[] convertToBytes(String data) throws UnsupportedEncodingException {
            // Normalize Unicode message to NFC form
            String normalizedPwd = Normalizer.normalize(data, Normalizer.Form.NFC);

            // Convert to bytes with UTF-8 charset
            return normalizedPwd.getBytes("UTF-8");
        }

        private static byte[] digest(byte[] digest, byte[] salt)
                throws UnsupportedEncodingException, NoSuchAlgorithmException {

            // Create digester
            if (null == digester) {
                digester = MessageDigest.getInstance("SHA-256");
            } else {
                digester.reset();
            }

            if (null != salt) {
                digester.update(salt);
            }

            digester.update(digest);

            // Generate hash
            byte[] hash = digester.digest();

            // Iterate
            for (int i = 0; i < ITERATIONS - 1; i++) {
                digester.reset();
                hash = digester.digest(hash);
            }

            // Prefix result with salt
            if (null != salt) {
                byte[] combined = new byte[salt.length + hash.length];
                System.arraycopy(salt, 0, combined, 0, salt.length);
                System.arraycopy(hash, 0, combined, salt.length, hash.length);
                hash = combined;
            }

            return hash;
        }
    }
}
