package test

import models.Report
import models.Transaction
import models.TransactionType
import summary.CalculatorImpl
import java.time.LocalDate

fun test(){



    var dumyData= listOf<Transaction>(
        Transaction(LocalDate.of(2024, 4, 1), 1000.0, "Salary", TransactionType.INCOME),
        Transaction(LocalDate.of(2024, 4, 2), 200.0, "Gift", TransactionType.INCOME),
        Transaction(LocalDate.of(2024, 4, 3), 500.0, "Rent", TransactionType.EXPENSE),
        Transaction(LocalDate.of(2024, 4, 4), 100.0, "Food", TransactionType.EXPENSE)
    )

    val calculatorReport=CalculatorImpl(dumyData)


    // Valid TestCase
    check(
        name = ("Check for valid Transaction list Size"),
        expectedResult =calculatorReport.calculateIncomesReport().transactions.size,
        correctResult =2
    )
    check(
        name = ("Check for valid amount"),
        expectedResult =calculatorReport.calculateIncomesReport().sum,
        correctResult =1200.0
    )
    ////////////////////////////////////////////////////

    // Invalid TestCase

    check(
        name = ("Check for wrong amount"),
        expectedResult =calculatorReport.calculateExpensesReport().sum,
        correctResult =400.0
    )
    check(
        name = ("Check for invalid Transaction list Size"),
        expectedResult =calculatorReport.calculateExpensesReport().transactions.size,
        correctResult =5
    )

    check(
        name = ("Empty transaction list"),
        expectedResult =calculatorReport.calculateExpensesReport().transactions.size,
        correctResult =0,
    )

}


fun main(){

    test()





}