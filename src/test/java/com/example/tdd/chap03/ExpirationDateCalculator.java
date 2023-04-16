package com.example.tdd.chap03;

import java.time.LocalDate;

class ExpirationDateCalculator {
    public LocalDate calculateExp(PayData payData) {
        return payData.getBillingDate().plusMonths(1);
    }

    public LocalDate calculateExp1(PayData1 payData1) {
        return payData1.getBillingDate1().plusMonths(1);
    }


}
