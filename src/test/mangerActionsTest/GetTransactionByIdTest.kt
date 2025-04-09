package test.mangerActionsTest

import models.Transaction
import models.TransactionType
import test.check
import java.time.LocalDate


fun getTransactionTestCases() {

    val transactionMangerActionsTest = TransactionMangerActionsTest()

    val validTransaction = Transaction(
        id = 1,
        date = LocalDate.now(),
        amount = 12000.0,
        category = "Food",
        type = TransactionType.INCOME
    )

    val inputTransactionId = 1

    check<Transaction>(
        name = "when a valid transaction id is true should return transaction",
        expectedResult = transactionMangerActionsTest.getTransactionById(inputTransactionId)!!,
        correctResult = validTransaction
    )
}