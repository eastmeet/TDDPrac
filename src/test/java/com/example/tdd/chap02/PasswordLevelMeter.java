package com.example.tdd.chap02;


/**
 * ==== 검사할 규칙 ====
 * password length >= 8
 * 0부터 9사이의 숫자를 포함
 * 대문자 포함
 * matchCount : 3 -> STRONG, 2 -> NORMAL, 1 -> WEAK
 */
public class PasswordLevelMeter {
    public PasswordStrength evaluatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int matchCount = getMatchingCountByConditions(password);

        if (matchCount <= 1) {
            return PasswordStrength.WEAK;
        }

        if (matchCount == 2) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private static int getMatchingCountByConditions(String password) {
        int matchCount = 0;

        if (password.length() >= 8) {
            matchCount++;
        }

        if (isContainsNum(password)) {
            matchCount++;
        }

        if (isContainUPP(password)) {
            matchCount++;
        }

        return matchCount;
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
