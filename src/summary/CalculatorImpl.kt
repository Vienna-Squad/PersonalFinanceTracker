package summary

import models.Transaction
import models.TransactionType


class CalculatorImpl:Calculator{
    override fun calculateIncomes(transactions: List<Transaction>): Double{
        val incomes = transactions.filter { it.type == TransactionType.INCOME }
        return incomes.sumOf { it.amount }
    }

    override fun calculateExpenses(transactions: List<Transaction>): Double {
        val expenses = transactions.filter { it.type == TransactionType.EXPENSE }
        return expenses.sumOf { it.amount }
    }

    override fun calculateSummaryOfMonth(transactions: List<Transaction>, month: Int): Double {
        var monthTotalSum = 00.0
        for (transaction in transactions) {
            if (transaction.type == TransactionType.INCOME) monthTotalSum += transaction.amount
            else monthTotalSum -= transaction.amount
        }
        return monthTotalSum
    }
}
