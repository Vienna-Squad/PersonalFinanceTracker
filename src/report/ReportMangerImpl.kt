package report

import models.Transaction
import summary.Calculator
import summary.CalculatorImpl


class ReportMangerImpl(
    private val transactions: List<Transaction>?=emptyList(),
    private val calculator: Calculator = CalculatorImpl()
) : ReportManger {
    override fun showReportOfSummaryOfMonthReport(month: Int): Report {
        val monthSummarySum = calculator.calculateSummaryOfMonth(transactions?:emptyList(),month)
        return Report(
            title = "Month Sum",
            transactions = transactions?:emptyList(),
            result = monthSummarySum ,
        )
    }

    override fun showIncomesReport(): Report {
        val income = calculator.calculateIncomes(transactions?:emptyList())
        return Report(
            title = " Income Report ",
            transactions = transactions?:emptyList(),
            result = income ,
        )
    }

    override fun showExpensesReport(): Report {
       val expense = calculator.calculateExpenses(transactions?:emptyList())
        return Report(
            title = " expense Report ",
            transactions = transactions?:emptyList(),
            result = expense
        )
    }

    override fun showBalanceReport(): Report {
        val transactionsList = transactions?:emptyList()
        val balance = calculator.calculateIncomes(transactionsList) - calculator.calculateExpenses(transactionsList)
        return Report(
            title = "Balance Report",
            transactions = transactionsList,
            result = balance
        )
    }
}
