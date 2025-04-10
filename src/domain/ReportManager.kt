package domain

import model.Report

interface ReportManager {
    fun getIncomeTransactionsReport(): Report
    fun getExpenseTransactionsReport(): Report
    fun getTransactionReportOfMonth(month: Int): Report
}