package manager

import models.Transaction
import java.util.*

interface TransactionManger {
    fun addTransaction(transaction: Transaction): Boolean
    fun deleteTransaction(id: Int):Boolean
    fun updateTransaction(transaction: Transaction): Boolean
    fun getAllTransactions(): List<Transaction>?
    fun getTransactionById(id: Int): Transaction?
}