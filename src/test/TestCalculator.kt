package test

import models.Transaction
import models.TransactionType
import summary.CalculatorImpl
import java.time.LocalDate

fun main() {
testSummaryCalculator()
}

fun testSummaryCalculator() {
    val dummyTransactions = listOf(
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
    val calculator = CalculatorImpl(dummyTransactions)
//region valid transactions
    check(
        name = "Valid Summary Filtered By Month Transactions ",
        expectedResult = calculator.calculateSummaryOfMonth(4).transactions.size,
        correctResult = dummyTransactions.size
    )
    check(
        name = "Valid Calculated Balance of Income & Expense ",
        expectedResult = calculator.calculateSummaryOfMonth(4).sum,
        correctResult = 500.0
    )
//endregion
//region invalid transaction count of month
    val dummyTransactions2 = listOf (
        Transaction(
            date = LocalDate.of(2025,3,28),
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

    val calculator2 = CalculatorImpl(dummyTransactions2)
    //invalid
    check(
        name = "Wrong output of  Filtered By Month Transactions ",
        expectedResult = calculator2.calculateSummaryOfMonth(4).transactions.size ,
        correctResult = 3
    )
    //endregion
}