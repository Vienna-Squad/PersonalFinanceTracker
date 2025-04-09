package summary

import models.Report
import models.Transaction
import models.TransactionType
import java.time.LocalDate

class CalculatorImpl(val transactionsList: List<Transaction>) : Calculator {
    override fun calculateSummaryOfMonth(month: Int): Report {
        var monthTotalSum = 00.0
        for (transaction in transactionsList) {
            if (transaction.type == TransactionType.INCOME) monthTotalSum += transaction.amount
            else monthTotalSum -= transaction.amount
        }
        val monthlyFilterList = transactionsList.filter { it.date.monthValue == month }
        val monthlySummary = Report(
            monthlyFilterList,
            monthTotalSum,
            "Summary of ${LocalDate.now().month} Transactions "

        )
        return monthlySummary
    }

    override fun calculateIncomesReport(): Report {
        TODO("Not yet implemented")
    }

    override fun calculateExpensesReport(): Report {
        TODO("Not yet implemented")
    }

}