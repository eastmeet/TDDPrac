package com.example.tdd.chap02;


/**
 * ==== 검사할 규칙 ====
 * 길이가 8글자 이상
 * 0부터 9사이의 숫자를 포함
 * 대문자 포함
 * ==== 조건 충족 시====
 * 3가지 -> STRONG
 * 2가지 -> NORMAL
 * 1가지 -> WEAK
 */
public class PasswordLevelMeter {
    public PasswordStrength evaluatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int metCount = 0;

        if (password.length() >= 8) {
            metCount++;
        }

        if (isContainsNum(password)) {
            metCount++;
        }

        if (isContainUPP(password)) {
            metCount++;
        }

        if (metCount == 1) {
            return PasswordStrength.WEAK;
        }

        if (metCount == 2) {
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
