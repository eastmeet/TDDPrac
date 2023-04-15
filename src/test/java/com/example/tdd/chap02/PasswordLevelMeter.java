package com.example.tdd.chap02;

public class PasswordLevelMeter {
    public PasswordStrength evaluatePassword(String password) {
        if (password.length() < 8) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

}
