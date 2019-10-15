package com.fnmusic.base.utils;

import java.security.SecureRandom;

public class RandomGeneratorUtils {

    public static SecureRandom secureRandom = new SecureRandom();

    public static String generateCode(CharacterType type, int length) {

        switch (type) {
            case NUMERIC:
                return numeric(length);
            case ALPHANUMERIC:
                return alphanumeric(length);
            case ALPHABETIC:
                return alphabetic(length);
        }

        return null;
    }

    private static String numeric(int length) {
        String SOURCE = "1234567890";
        return generateRandomString(length,SOURCE);
    }

    private static String alphanumeric(int length) {
        String SOURCE = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return generateRandomString(length,SOURCE);
    }

    private static String alphabetic(int length) {
        String SOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return generateRandomString(length,SOURCE);
    }

    private static String generateRandomString(int length, String SOURCE) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = secureRandom.nextInt(SOURCE.length());
            sb.append(SOURCE.charAt(index));
        }
        return sb.toString();
    }
}
