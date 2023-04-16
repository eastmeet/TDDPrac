package com.example.tdd.chap03;

import java.time.LocalDate;

class ExpirationDateCalculator {
    public LocalDate calculateExp(PayData payData) {
        return payData.getBillingDate().plusMonths(1);
    }

}
