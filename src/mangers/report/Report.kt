package mangers.report

interface Report {
    fun calculateSummaryOfMonthReport(month: Int): ReportModel
    fun calculateIncomesReport(): ReportModel
    fun calculateExpensesReport(): ReportModel
}