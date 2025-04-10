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

    override fun calculateExpensesReport(): ReportModel {
        val title  = "Total of expenses"
        val expenses = transactionManger.getAllTransactions().filter { it.type == TransactionType.EXPENSE }
        val totalExpense = expenses.sumOf { it.amount }
        return ReportModel(expenses, totalExpense,title)
    }

    override fun calculateSummaryOfMonthReport(month: Int): ReportModel {
        var monthTotalSum = 00.0
        for (transaction in transactionManger.getAllTransactions()) {
            if (transaction.type == TransactionType.INCOME) monthTotalSum += transaction.amount
            else monthTotalSum -= transaction.amount
        }
        val monthlyFilterList = transactionManger.getAllTransactions().filter { it.date.monthValue == month }
        val monthlySummary = ReportModel(
            monthlyFilterList,
            monthTotalSum,
            "Summary of ${LocalDate.now().month} Transactions "

        )
        return monthlySummary
    }
}
