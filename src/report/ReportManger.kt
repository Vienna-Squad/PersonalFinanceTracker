package report


interface ReportManger {
    fun showReportOfSummaryOfMonthReport(month: Int): Report
    fun showIncomesReport(): Report
    fun showExpensesReport(): Report
    fun showBalanceReport(): Report
}