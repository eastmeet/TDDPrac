package com.example.tdd.chap03;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
public class PayData1 {
    private LocalDate billingDate1;
    private int payAmount1;
    private LocalDate expectedExpiryDate1;

    @Builder
    public PayData1(LocalDate billingDate1, int payAmount1) {
        this.billingDate1 = billingDate1;
        this.payAmount1 = payAmount1;
    }
}

