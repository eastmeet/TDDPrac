package com.example.tdd.chap03;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 서비스를 사용하려면 매달 1만원을 선불 납부
 * 납부일 기준 한달 뒤가 서비스 만료일
 * 2개월 이상 요금을 납부 할 수 있음
 * 10만원을 납부하면 서비스를 1년 제공 (2만원 이득)
 */
public class ExpirationDateCalculatorTest {

    @Test
    void calcExpirationDate() {
        LocalDate billingDate = LocalDate.of(2019, 3, 1);
        int payAmount = 10_000;
        LocalDate expectedExpiryDate = LocalDate.of(2019, 4, 1);

        assertExpirationDate(billingDate, payAmount, expectedExpiryDate);

        LocalDate billingDate1 = LocalDate.of(2019, 5, 1);
        int payAmount1 = 10_000;

        assertExpirationDate(billingDate1, payAmount1, LocalDate.of(2019, 6, 1));

    }

    private void assertExpirationDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
        ExpirationDateCalculator cal = new ExpirationDateCalculator();
        LocalDate expirationDate = cal.calculateExp(billingDate, payAmount);

        Assertions.assertThat(expirationDate).isEqualTo(expectedExpiryDate);
    }

    private class ExpirationDateCalculator {
        public LocalDate calculateExp(LocalDate billingDate, int payAmount) {
            return billingDate.plusMonths(1);
        }
    }

    @Test
    void handleException() {
        assertExpirationDate(
                LocalDate.of(2019, 1, 31), 10_000,
                LocalDate.of(2019, 2, 28)
        );

        assertExpirationDate(
                LocalDate.of(2019, 5, 31), 10_000,
                LocalDate.of(2019, 6, 30)
        );

        assertExpirationDate(
                LocalDate.of(2020, 1, 31), 10_000,
                LocalDate.of(2020, 2, 29)
        );

    }

    // 구현하기 쉬운 것부터 테스트하자.
    // 예외 상황을 먼저 테스트 한다.
}
