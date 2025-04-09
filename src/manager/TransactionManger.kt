package manager

import models.Transaction

interface TransactionManger {
    fun addTransaction(transaction: Transaction): Boolean
    fun deleteTransaction(id: Int):Boolean
    fun updateTransaction(transaction: Transaction): Boolean
    fun getAllTransactions(): List<Transaction>?
    fun getTransactionById(id:Int): Transaction?
}