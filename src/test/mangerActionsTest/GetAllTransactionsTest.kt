package test.mangerActionsTest
import models.Transaction
import models.TransactionType
import test.check
import java.time.LocalDate

fun getAllTransactionsTestCases() {
    check(
        name = "when there are no transactions should return empty list",
        expectedResult = mangerActionsTest.getAllTransactions(),
        correctResult = emptyList()
    )

    // First add some transactions
    mangerActionsTest.addTransaction(
        Transaction(
            date = LocalDate.now(),
            amount = 1000.0,
            category = "Salary",
            type = TransactionType.INCOME
        )
    )

    mangerActionsTest.addTransaction(
        Transaction(
            date = LocalDate.now(),
            amount = -50.0,
            category = "Food",
            type = TransactionType.EXPENSE
        )
    )

    check(
        name = "when there are transactions should return non-empty list",
        expectedResult = mangerActionsTest.getAllTransactions(),
        correctResult = listOf(
            Transaction(
                date = LocalDate.now(),
                amount = 1000.0,
                category = "Salary",
                type = TransactionType.INCOME
            ),
            Transaction(
                date = LocalDate.now(),
                amount = -50.0,
                category = "Food",
                type = TransactionType.EXPENSE
            )
        )
    )

    check(
        name = "should return correct number of transactions",
        expectedResult = mangerActionsTest.getAllTransactions().size,
        correctResult = 2
    )

    // Test for transaction order
    check(
        name = "transactions should be ordered by date",
        expectedResult = mangerActionsTest.getAllTransactions()
            .zipWithNext { a, b -> a.date <= b.date }
            .all { it },
        correctResult = true
    )

}