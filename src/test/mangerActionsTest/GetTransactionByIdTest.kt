package test.mangerActionsTest

import models.Transaction
import models.TransactionType
import test.check
import java.time.LocalDate


fun getTransactionTestCases() {

    val mangerActionsTest = MangerActionsTest()

    val validTransaction = Transaction(
        // in case id is 3
        date = LocalDate.now(),
        amount = 12000.0,
        category = "Food",
        type = TransactionType.INCOME
    )

    val transactionId = 3

    check<Transaction>(
        name = "when a valid transaction id is true should return transaction",
        expectedResult = mangerActionsTest.getTransactionById(transactionId)!!,
        correctResult = validTransaction
    )
}