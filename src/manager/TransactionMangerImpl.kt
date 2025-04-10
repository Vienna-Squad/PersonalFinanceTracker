package manager

import models.Report
import models.Transaction
import models.TransactionType
import summary.Calculator
import java.time.Month

class TransactionMangerImpl(
    private val calculator: Calculator
) : TransactionManger {
    private val transactions = mutableListOf<Transaction>()
    override fun addTransaction(transaction: Transaction): Boolean {
        return transactions.add(transaction)
    }

    override fun deleteTransaction(id: Int): Boolean {
        return transactions.removeIf { transactionItem -> transactionItem.id == id }
    }

    override fun updateTransaction(transaction: Transaction): Boolean {
        val transactionIndex = transactions.indexOf(transaction)
        return if (transactionIndex != -1) {
            transactions[transactionIndex] = transaction
            true
        } else
            false
    }

    override fun getAllTransactions(): List<Transaction> = transactions

    override fun getTransactionById(id: Int): Transaction? {
        return transactions.firstOrNull { it.id == id }
    }

    override fun getTransactionsByType(transactionType: TransactionType): List<Transaction>? {
        return transactions.filter { item -> item.type == transactionType }
    }

    override fun getTransactionsReportByType(transactionType: TransactionType): Report {
        return when(transactionType){
            TransactionType.INCOME -> calculator.calculateIncomesReport()
            TransactionType.EXPENSE -> calculator.calculateExpensesReport()
        }
    }

    override fun getTransactionsByMonth(month: Month): List<Transaction>?{
        return transactions.filter { item -> item.date.month == month }
    }

    override fun getTransactionReportOfMonth(month: Month): Report {
        return calculator.calculateSummaryOfMonth(month.value)
    }
}