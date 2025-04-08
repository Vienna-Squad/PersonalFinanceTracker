package managers

import models.Transaction

interface TransactionsManager {
    fun addTransaction(transaction: Transaction): Boolean
    fun deleteTransaction(transaction: Transaction): Boolean
    fun updateTransaction(transaction: Transaction): Boolean
    fun getAllTransaction():List<Transaction>
}