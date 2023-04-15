package com.example.tdd.chap02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * ==== 검사할 규칙 ====
 * 길이가 8글자 이상
 * 0부터 9사이의 숫자를 포함
 * 대문자 포함
 * ==== 조건 충족 시====
 * 3가지 -> STRONG
 * 2가지 ->
 * 1가지
 */
public class PasswordLevelMeterTest {
    @Test
    void validateStrongPasswordWithAllCriteria() {
        PasswordLevelMeter meter = new PasswordLevelMeter();
        String password = "ab12!@AB";
        PasswordStrength result = meter.evaluatePassword(password);
        Assertions.assertThat(result).isEqualTo(PasswordStrength.STRONG);

        PasswordStrength result2 = meter.evaluatePassword("abc1!Add");
        Assertions.assertThat(result2).isEqualTo(PasswordStrength.STRONG);

    }
}
