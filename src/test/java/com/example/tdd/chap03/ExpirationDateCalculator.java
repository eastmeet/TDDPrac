package com.example.tdd.chap03;

import java.time.LocalDate;

class ExpirationDateCalculator {
    public LocalDate calculateExp(PayData payData) {
        int addedMonths = 1;
        if (payData.getFirstBillingDate() != null) {
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
            if (payData.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
            }
        }
        return payData.getBillingDate().plusMonths(addedMonths);
    }

    public LocalDate calculateExp1(PayData1 payData1) {
        return payData1.getBillingDate1().plusMonths(1);
    }


}
