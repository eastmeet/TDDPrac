package com.example.tdd.chap03;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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

        assertExpirationDate(new PayData(billingDate, payAmount), expectedExpiryDate);

        LocalDate billingDate1 = LocalDate.of(2019, 5, 1);
        int payAmount1 = 10_000;

        assertExpirationDate(new PayData(billingDate1, payAmount1), LocalDate.of(2019, 6, 1));

    }

    private void assertExpirationDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpirationDateCalculator cal = new ExpirationDateCalculator();
        LocalDate expirationDate = cal.calculateExp(payData);

        Assertions.assertThat(expirationDate).isEqualTo(expectedExpiryDate);
    }

    private void assertExpirationDate1(PayData1 payData1, LocalDate expectedExpiryDate) {
        ExpirationDateCalculator cal = new ExpirationDateCalculator();
        LocalDate expirationDate = cal.calculateExp1(payData1);

        Assertions.assertThat(expirationDate).isEqualTo(expectedExpiryDate);
    }


    @Test
    void handleException() {
        assertExpirationDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 4, 1)
        );

        assertExpirationDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 2, 28)
        );

        assertExpirationDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 1, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2020, 2, 29)
        );

        assertExpirationDate1(
                PayData1.builder()
                        .billingDate1(LocalDate.of(2020, 1, 31))
                        .payAmount1(10_000)
                        .build(),
                LocalDate.of(2020, 2, 29)
        );

    }

}
