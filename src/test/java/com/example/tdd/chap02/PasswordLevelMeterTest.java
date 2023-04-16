package com.example.tdd.chap02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.filter.TypeExcludeFilters;


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

    @Test
    void nullInput() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void emptyInput() {
        assertStrength("", PasswordStrength.INVALID);
    }

    @Test
    void validateNormalPasswordWithTwoCriteriaExcludingUpperCase() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    @Test
    void validateWeakPasswordWithOnlyPasswordLength() {
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }

    @Test
    void validateWeakPasswordWithOnlyNumber() {
        assertStrength("12345", PasswordStrength.WEAK);
    }

    @Test
    void validateWeakPasswordWithOnlyUpperCondition() {
        assertStrength("ABCDE", PasswordStrength.WEAK);
    }
}
