package manager

import models.Report
import models.Transaction
import summary.Calculator
import java.time.Month

class TransactionMangerImpl(val reportManager:ReportManager) : TransactionManger,ReportManager by reportManager {
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

    override fun getIncomeTransactionsReport(): Report {
        TODO("Not yet implemented")
    }

    override fun getExpenseTransactionsReport(): Report {
        TODO("Not yet implemented")
    }

    override fun getTransactionReportOfMonth(month: Month): Report {
        TODO("Not yet implemented")
    }

}