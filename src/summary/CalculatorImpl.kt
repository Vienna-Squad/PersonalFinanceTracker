package summary

import models.Report
import models.Transaction

class CalculatorImpl(val transaction:List<Transaction>):Calculator{


    override fun calculateSummaryOfMonth(month: Int): Report {
        TODO("Not yet implemented")
    }

    override fun calculateIncomesReport(): Report {
        return Report()
    }

    override fun calculateExpensesReport(): Report {
        return Report()
    }


}