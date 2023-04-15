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

    private PasswordLevelMeter meter = new PasswordLevelMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.evaluatePassword(password);
        Assertions.assertThat(result).isEqualTo(expStr);
    }

    @Test
    void validateStrongPasswordWithAllCriteria() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);

    }

    @Test
    void validateNormalPasswordWithTwoCriteriaExcludingLength() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("AB12!c", PasswordStrength.NORMAL);
    }

    @Test
    void validateNormalPasswordWithTwoCriteriaExcludingNumber() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }
}
