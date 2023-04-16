package com.example.tdd.chap03;

import java.time.LocalDate;
import java.time.YearMonth;

class ExpirationDateCalculator {
    public LocalDate calculateExp(PayData payData) {
        int addedMonths = (payData.getPayAmount() >= 100_000) ? 12 + (payData.getPayAmount() - 100_000) / 10_000  : (payData.getPayAmount() / 10_000);
        if (payData.getFirstBillingDate() != null) {
            return expirationDateUsingFirstBillingDate(payData, addedMonths);
        } else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private static LocalDate expirationDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
        if (dayOfFirstBilling != candidateExp.getDayOfMonth()) {
            final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
            if (dayLenOfCandiMon < dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }
    }

    public LocalDate calculateExp1(PayData1 payData1) {
        return payData1.getBillingDate1().plusMonths(1);
    }
}
