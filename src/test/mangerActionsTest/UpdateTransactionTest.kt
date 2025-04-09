package test.mangerActionsTest
import models.Transaction
import models.TransactionType
import java.time.LocalDate

fun updateTransactionTestCases() {
    test.check(
        name = "when updating transaction with zero amount should return false",
        expectedResult = mangerActionsTest.updateTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 0.0,
                category = "Food",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )

    test.check(
        name = "when updating transaction with positive amount but expense type should return false",
        expectedResult = mangerActionsTest.updateTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 500.0,
                category = "Salary",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )

    test.check(
        name = "when updating transaction with negative amount but income type should return false",
        expectedResult = mangerActionsTest.updateTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = -100.0,
                category = "Freelance",
                type = TransactionType.INCOME
            )
        ),
        correctResult = false
    )

    test.check(
        name = "when updating transaction with empty category should return false",
        expectedResult = mangerActionsTest.updateTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 150.0,
                category = "",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )

    test.check(
        name = "when updating transaction with invalid amount format should return false",
        expectedResult = mangerActionsTest.updateTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = "@#100.0".toDouble(),
                category = "Shopping",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )

    test.check(
        name = "when updating transaction with valid data should return true",
        expectedResult = mangerActionsTest.updateTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 200.0,
                category = "Groceries",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = true
    )
}