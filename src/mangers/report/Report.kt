package mangers.report

interface Report {
    fun generateSummaryOfMonthReport(month: Int): ReportModel
    fun calculateIncomesReport(): ReportModel
    fun generateExpensesReport(): ReportModel
}