package test.mangerActionsTest

import manager.TransactionManger
import models.Report
import models.Transaction
import java.time.Month

class TransactionMangerActionsTest(): TransactionManger{
    override fun addTransaction(transaction: Transaction): Boolean {
        return false
    }

    override fun deleteTransaction(id: Int): Boolean {
        return false
    }

    override fun updateTransaction(transaction: Transaction): Boolean {
        return false
    }

    override fun getAllTransactions(): List<Transaction> {
        return emptyList()
    }

    override fun getTransactionById(id: Int): Transaction? {
        return null
    }

    override fun getTransactionsIncomeReport(): Report {
        return Report()
    }

    override fun getTransactionsExpenseReport(): Report {
        return Report()
    }

    override fun getTransactionReportOfMonth(month: Month): Report {
        return Report()
    }
}



