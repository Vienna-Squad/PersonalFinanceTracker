package summary

import models.Report
import models.Transaction

class CalculatorImpl(transaction: List<Transaction>): Calculator {
    override fun calculateSummaryOfMonth(month: Int): Report {
        return Report()
    }

    override fun calculateIncomesReport(): Report {
        TODO("Not yet implemented")
    }

    override fun calculateExpensesReport(): Report {
        TODO("Not yet implemented")
    }

}