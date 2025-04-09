package test.mangerActionsTest

import models.Transaction
import models.TransactionType
import test.check
import java.time.LocalDate



fun deleteTransactionTestCases() {

    val transactionMangerActionsTest = TransactionMangerActionsTest()

    val validTransaction = Transaction(
        id = 1,
        date = LocalDate.now(),
        amount = 12000.0,
        category = "Salary",
        type = TransactionType.INCOME
    )

    check<Boolean>(
        name = "when a transaction is valid should return true",
        expectedResult = transactionMangerActionsTest.updateTransaction(transaction =validTransaction ),
        correctResult = true
    )
}