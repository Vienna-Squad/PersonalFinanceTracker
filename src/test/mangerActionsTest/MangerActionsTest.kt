package test.mangerActionsTest

import manager.ManagerActions
import models.Transaction

class MangerActionsTest(): ManagerActions{
    override fun addTransaction(transaction: Transaction): Boolean {
        return false
    }

    override fun deleteTransaction(id: Int): Boolean {
        return false
    }

    override fun updateTransaction(transaction: Transaction): Boolean {
        return false
    }

    override fun getAllTransactions(): List<Transaction> {
        return emptyList()
    }

    override fun getTransactionById(id: Int): Transaction? {
        return null
    }
}



