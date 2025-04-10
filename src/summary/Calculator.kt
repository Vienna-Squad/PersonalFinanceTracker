package summary

import report.Report
import models.Transaction

interface Calculator {
    fun calculateSummaryOfMonth(transactions: List<Transaction>, month: Int): Double
    fun calculateIncomes(transactions: List<Transaction>): Double
    fun calculateExpenses(transactions: List<Transaction>): Double
}