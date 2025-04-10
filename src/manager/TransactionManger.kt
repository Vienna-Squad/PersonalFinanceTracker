package manager

import models.Report
import models.Transaction
import java.time.Month

interface TransactionManger {
    fun addTransaction(transaction: Transaction): Boolean
    fun deleteTransaction(id: Int): Boolean
    fun updateTransaction(transaction: Transaction): Boolean
    fun getTransactionById(id: Int): Transaction?
    fun getAllTransactions(): List<Transaction>
}

interface ReportManager {
    fun getIncomeTransactionsReport(): Report
    fun getExpenseTransactionsReport(): Report
    fun getTransactionReportOfMonth(month: Month): Report
}