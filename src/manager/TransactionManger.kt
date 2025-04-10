package manager

import models.Report
import models.Transaction
import models.TransactionType
import java.time.Month

interface TransactionManger {
    fun addTransaction(transaction: Transaction): Boolean
    fun deleteTransaction(id: Int):Boolean
    fun updateTransaction(transaction: Transaction): Boolean
    fun getAllTransactions(): List<Transaction>
    fun getTransactionById(id: Int): Transaction?
    fun getTransactionsByType(transactionType: TransactionType): List<Transaction>?
    fun getTransactionsReportByType(transactionType: TransactionType): Report
    fun getTransactionsByMonth(month: Month): List<Transaction>?
    fun getTransactionReportOfMonth(month: Month): Report
}