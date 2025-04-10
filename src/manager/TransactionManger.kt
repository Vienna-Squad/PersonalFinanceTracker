package manager

import report.Report
import models.Transaction
import models.TransactionType
import java.time.Month

interface TransactionManger {
    fun addTransaction(transaction: Transaction): Boolean
    fun deleteTransaction(id: Int):Boolean
    fun updateTransaction(transaction: Transaction): Boolean
    fun getAllTransactions(): List<Transaction>
    fun getTransactionById(id: Int): Transaction?
//    fun getTransactionsIncomeReport(): Report
//    fun getTransactionsExpenseReport(): Report
//    fun getTransactionReportOfMonth(month: Month): Report
}


