package manager

import models.Report
import summary.Calculator
import java.time.Month

class ReportManagerImp(private val calculator: Calculator) : ReportManager {
    override fun getIncomeTransactionsReport() = calculator.calculateIncomesReport()
    override fun getExpenseTransactionsReport() = calculator.calculateExpensesReport()
    override fun getTransactionReportOfMonth(month: Month) = calculator.calculateSummaryOfMonth(month.value)
}