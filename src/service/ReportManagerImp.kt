package service

import domain.ReportManager
import domain.TransactionManager
import model.Report
import model.TransactionType
import java.time.Month

class ReportManagerImp(private val transactionManager: TransactionManager) : ReportManager {

    override fun getIncomeTransactionsReport() = calculateIncomesReport()

    override fun getExpenseTransactionsReport() = calculateExpensesReport()

    override fun getTransactionReportOfMonth(month: Int) = calculateSummaryOfMonth(month = month)

    private fun calculateIncomesReport(): Report {
        val title = "Total of incomes"
        val incomes = transactionManager.getAllTransactions().filter { it.type == TransactionType.INCOME }
        val totalIncome = incomes.sumOf { it.amount }
        return Report(incomes, totalIncome, title)
    }

    private fun calculateExpensesReport(): Report {
        val title = "Total of expenses"
        val expenses = transactionManager.getAllTransactions().filter { it.type == TransactionType.EXPENSE }
        val totalExpense = expenses.sumOf { it.amount }
        return Report(expenses, totalExpense, title)
    }

    private fun calculateSummaryOfMonth(month: Int): Report {
        var monthTotalSum = 00.0
        val monthlyFilterList = transactionManager.getAllTransactions().filter { it.date.monthValue == month }
        for (transaction in monthlyFilterList) {
            if (transaction.type == TransactionType.INCOME) monthTotalSum += transaction.amount
            else monthTotalSum -= transaction.amount
        }
        val monthlySummary = Report(
            monthlyFilterList,
            monthTotalSum,
            "Summary of ${Month.entries[month - 1]} Transactions "

        )
        return monthlySummary
    }

}