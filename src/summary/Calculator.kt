package summary

import models.Report
import models.Transaction

interface Calculator {
    fun calculateSummaryOfMonth(month: Int,transactions:List<Transaction>): Report
    fun calculateIncomesReport(transactions:List<Transaction>): Report
    fun calculateExpensesReport(transactions:List<Transaction>): Report
}