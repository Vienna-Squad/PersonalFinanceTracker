
import models.Transaction
import models.TransactionType
import test.mangerActionsTest.TransactionMangerActionsTest
import java.time.LocalDate

fun updateTransactionTestCases() {

    val transactionMangerActionsTest = TransactionMangerActionsTest()
    test.check(
        name = "when updating transaction with zero amount should return false",
        expectedResult = transactionMangerActionsTest.updateTransaction(
            Transaction(
                id = 1,
                date = LocalDate.now(),
                amount = 0.0,
                category = "Food",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )

    test.check(
        name = "when updating transaction with empty category should return false",
        expectedResult = transactionMangerActionsTest.updateTransaction(
            Transaction(
                id = 1,
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
        expectedResult = transactionMangerActionsTest.updateTransaction(
            Transaction(
                id = 1,
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
        expectedResult = transactionMangerActionsTest.updateTransaction(
            Transaction(
                id = 1,
                date = LocalDate.now(),
                amount = 200.0,
                category = "Groceries",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = true
    )

    // Amount Field Tests
    test.check(
        name = "when amount is negative should return false",
        expectedResult = transactionMangerActionsTest.updateTransaction(
            Transaction(
                id = 1,
                date = LocalDate.now(),
                amount = -50.0,
                category = "Valid",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )

    // Category Field Tests
    test.check(
        name = "when category is blank should return false",
        expectedResult = transactionMangerActionsTest.updateTransaction(
            Transaction(
                id = 1,
                date = LocalDate.now(),
                amount = 100.0,
                category = "   ",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )

    test.check(
        name = "when category exceeds maximum length should return false",
        expectedResult = transactionMangerActionsTest.updateTransaction(
            Transaction(
                id = 1,
                date = LocalDate.now(),
                amount = 100.0,
                category = "A".repeat(51), // Assuming 50 is max length
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )

    // Transaction Type Tests
    test.check(
        name = "when type is EXPENSE with negative amount should return false",
        expectedResult = transactionMangerActionsTest.updateTransaction(
            Transaction(
                id = 1,
                date = LocalDate.now(),
                amount = -100.0,
                category = "Valid",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )

    test.check(
        name = "when type is INCOME with negative amount should return false",
        expectedResult = transactionMangerActionsTest.updateTransaction(
            Transaction(
                id = 1,
                date = LocalDate.now(),
                amount = -100.0,
                category = "Valid",
                type = TransactionType.INCOME
            )
        ),
        correctResult = false
    )


    // Valid Cases for Each Field
    test.check(
        name = "when all fields are valid should return true",
        expectedResult = transactionMangerActionsTest.updateTransaction(
            Transaction(
                id = 1,
                date = LocalDate.now(),
                amount = 100.0,
                category = "Valid Category",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = true
    )
}