package manager

import models.Transaction

interface ManagerActions {
    fun addTransaction(transaction: Transaction): Boolean
    fun deleteTransaction(id: Int):Boolean
    fun updateTransaction(transaction: Transaction): Boolean
    fun getAllTransactions(): List<Transaction>
}