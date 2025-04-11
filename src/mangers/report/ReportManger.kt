package mangers.report

import mangers.TranasctionManger.TransactionType
import mangers.transaction.Transaction

import java.time.LocalDate


class ReportManger(private val transactionManger: Transaction): Report {
    override fun calculateIncomesReport(): ReportModel {
        val title = "Total of incomes"
        val incomes = transactionManger.getAllTransactions().filter { it.type == TransactionType.INCOME }
        val totalIncome = incomes.sumOf { it.amount }
        return ReportModel(incomes, totalIncome,title)
    }

    override fun generateExpensesReport(): ReportModel {
        val title  = "Total of expenses"
        val expenses = transactionManger.getAllTransactions().filter { it.type == TransactionType.EXPENSE }
        val totalExpense = expenses.sumOf { it.amount }
        return ReportModel(expenses, totalExpense,title)
    }

    override fun generateSummaryOfMonthReport(month: Int): ReportModel {
        var totalSum = 00.0

        val monthlyFilterList = transactionManger.getAllTransactions().filter { it.date.monthValue == month }
        for (transaction in monthlyFilterList) {
            if (transaction.type == TransactionType.INCOME) totalSum += transaction.amount
            else totalSum -= transaction.amount
        }
        val monthlySummary = ReportModel(
            monthlyFilterList,
            totalSum,
            "Summary of ${LocalDate.now().month} Transactions "

        )
        return monthlySummary
    }
}
