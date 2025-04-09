package summary

import models.Report
import models.Transaction
import models.TransactionType


class CalculatorImpl(val transaction:List<Transaction>):Calculator{


    override fun calculateSummaryOfMonth(month: Int): Report {
        TODO("Not yet implemented")
    }

    override fun calculateIncomesReport(): Report {
        val title = "Total of incomes"
        val incomes = transaction.filter { it.type == TransactionType.INCOME }
        val totalIncome = incomes.sumOf { it.amount }
        return Report(incomes, totalIncome)
    }

    override fun calculateExpensesReport(): Report {
        val title  = "Total of expenses"
        val expenses = transaction.filter { it.type == TransactionType.EXPENSE }
        val totalExpense = expenses.sumOf { it.amount }
        return Report(expenses, totalExpense)
    }

    }