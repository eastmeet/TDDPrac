package com.example.tdd.chap02;

public class PasswordLevelMeter {
    public PasswordStrength evaluatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        if (password.length() < 8) {
            return PasswordStrength.NORMAL;
        }

        boolean containsNum = isContainsNum(password);

        if (!containsNum) {
            return PasswordStrength.NORMAL;
        }

        boolean containUPP = isContainUPP(password);

        if (!containUPP) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private static boolean isContainUPP(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContainsNum(String password) {
        for (char ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

}
