package domain

import model.Transaction

interface TransactionManager {
    fun addTransaction(transaction: Transaction): Boolean
    fun deleteTransaction(id: Int): Boolean
    fun updateTransaction(transaction: Transaction): Boolean
    fun getAllTransactions(): List<Transaction>
    fun getTransactionById(id: Int): Transaction?
}