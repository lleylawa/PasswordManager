package org.example.passwordmanagerapp;

import java.util.Base64;
import java.util.Random;

public class PasswordUtil {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";

    public static String generatePassword(int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(rand.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static String encrypt(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static String decrypt(String encrypted) {
        return new String(Base64.getDecoder().decode(encrypted));
    }
}