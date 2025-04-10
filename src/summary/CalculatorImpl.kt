package summary

import models.Report
import models.Transaction
import models.TransactionType
import java.time.LocalDate


class CalculatorImpl(private val transactions:List<Transaction>):Calculator{
    override fun calculateIncomesReport(): Report {
        val title = "Total of incomes"
        val incomes = transactions.filter { it.type == TransactionType.INCOME }
        val totalIncome = incomes.sumOf { it.amount }
        return Report(incomes, totalIncome,title)
    }

    override fun calculateExpensesReport(): Report {
        val title  = "Total of expenses"
        val expenses = transactions.filter { it.type == TransactionType.EXPENSE }
        val totalExpense = expenses.sumOf { it.amount }
        return Report(expenses, totalExpense,title)
    }

    override fun calculateSummaryOfMonth(month: Int): Report {
        var monthTotalSum = 00.0
        for (transaction in transactions) {
            if (transaction.type == TransactionType.INCOME) monthTotalSum += transaction.amount
            else monthTotalSum -= transaction.amount
        }
        val monthlyFilterList = transactions.filter { it.date.monthValue == month }
        val monthlySummary = Report(
            monthlyFilterList,
            monthTotalSum,
            "Summary of ${LocalDate.now().month} Transactions "

        )
        return monthlySummary
    }
}
