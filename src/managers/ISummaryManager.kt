package managers

import models.Transaction

interface ISummaryManager {
    fun calculateSummeryOfMonth(
        month: Int, transactionModel: List<Transaction>): List<Transaction>
    fun calculateReportOfBalance()
}
