package manager

import models.Transaction

interface ManagerActions {
    fun addTransaction(transaction: Transaction)
    fun deleteTransaction(id: Int)
    fun updateTransaction(transaction: Transaction)
    fun getAllTransactions(): List<Transaction>
}