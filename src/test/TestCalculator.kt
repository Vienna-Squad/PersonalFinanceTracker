package test

import models.Report
import models.Transaction
import models.TransactionType
import summary.CalculatorImpl
import java.time.LocalDate

fun main() {
testSummaryCalculator()


}

fun testSummaryCalculator() {
    val dummyTransaction = listOf(
        Transaction(
            date = LocalDate.now(),
            amount = 2000.0,
            category = "Monthly Salary",
            type = TransactionType.INCOME
        ), Transaction(
            date = LocalDate.now(),
            amount = 1500.0,
            category = "Health",
            type = TransactionType.EXPENSE
        ) , Transaction(
            date = LocalDate.now(),
            amount = 500.0,
            category = "Freelance",
            type = TransactionType.INCOME
        ) , Transaction(
            date = LocalDate.now(),
            amount = 500.0,
            category = "Clothes",
            type = TransactionType.EXPENSE
        )
    )

    val calculator = CalculatorImpl(dummyTransaction)
    //valid
    check(
        name = "valid summary of size ",
        expectedResult = calculator.calculateSummaryOfMonth(4).transactions.size,
        correctResult = dummyTransaction.size
    )
    check(
        name = "balance of INCOME & EXPENSE",
        expectedResult = calculator.calculateSummaryOfMonth(4).sum,
        correctResult = 500.0
    )
    //invalid
    check(
        name = "invalid summary of sum",
        expectedResult = calculator.calculateSummaryOfMonth(4).sum ,
        correctResult = 0.0
    )


}