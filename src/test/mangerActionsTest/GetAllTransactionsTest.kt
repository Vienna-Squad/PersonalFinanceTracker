package test.mangerActionsTest
import models.Transaction
import models.TransactionType
import test.check
import java.time.LocalDate

fun getAllTransactionsTestCases() {
    val transactionMangerActionsTest = TransactionMangerActionsTest()
    check(
        name = "when there are no transactions should return empty list",
        expectedResult = transactionMangerActionsTest.getAllTransactions(),
        correctResult = emptyList()
    )

    // First add some transactions
    transactionMangerActionsTest.addTransaction(
        Transaction(
            date = LocalDate.now(),
            amount = 1000.0,
            category = "Salary",
            type = TransactionType.INCOME
        )
    )

    transactionMangerActionsTest.addTransaction(
        Transaction(
            date = LocalDate.now(),
            amount = 50.0,
            category = "Food",
            type = TransactionType.EXPENSE
        )
    )

    check(
        name = "when there are transactions should return non-empty list",
        expectedResult = transactionMangerActionsTest.getAllTransactions(),
        correctResult = listOf(
            Transaction(
                date = LocalDate.now(),
                amount = 1000.0,
                category = "Salary",
                type = TransactionType.INCOME
            ),
            Transaction(
                date = LocalDate.now(),
                amount = 50.0,
                category = "Food",
                type = TransactionType.EXPENSE
            )
        )
    )

    check(
        name = "should return correct number of transactions",
        expectedResult = transactionMangerActionsTest.getAllTransactions().size,
        correctResult = 2
    )

}