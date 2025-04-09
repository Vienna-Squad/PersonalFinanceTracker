package test.mangerActionsTest

import models.Transaction
import models.TransactionType
import test.check
import java.time.LocalDate


val mangerActionsTest = MangerActionsTest()

fun addTransactionTestCases() {

    check<Boolean>(
        name = "when an amount of transaction is zero should return false",
        expectedResult = mangerActionsTest.addTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 0.0,
                category = "Nothing",
                type = TransactionType.INCOME
            )
        ),
        correctResult = false
    )
    check<Boolean>(
        name = "when an amount of transaction is positive with expense should return false",
        expectedResult = mangerActionsTest.addTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 20000.0,
                category = "Salary",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )

    check<Boolean>(
        name = "when an amount of transaction is negative with income should return false",
        expectedResult = mangerActionsTest.addTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = -1200.0,
                category = "Sandwich Shaowerma",
                type = TransactionType.INCOME
            )
        ),
        correctResult = false
    )

    check<Boolean>(
        name = "when the category of transaction is empty should return false",
        expectedResult = mangerActionsTest.addTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 2344.0,
                category = "",
                type = TransactionType.INCOME
            )
        ),
        correctResult = false
    )

    check<Boolean>(
        name = "when an amount of transaction is not valid format should return false",
        expectedResult = mangerActionsTest.addTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = "#@-12043.0#$".toDouble(),
                category = "Home",
                type = TransactionType.INCOME
            )
        ),
        correctResult = false
    )

    check<Boolean>(
        name = "when the category of transaction is not valid format should return false",
        expectedResult = mangerActionsTest.addTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 21.33,
                category = "#@-12043.0#",
                type = TransactionType.INCOME
            )
        ),
        correctResult = false
    )

    check<Boolean>(
        name = "when add the valid transaction  should return true",
        expectedResult = mangerActionsTest.addTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 13300.0,
                category = "Freelancing",
                type = TransactionType.INCOME
            )
        ),
        correctResult = true
    )

}
