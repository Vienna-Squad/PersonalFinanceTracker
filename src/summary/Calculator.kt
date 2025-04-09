package summary

import models.Report

interface Calculator {
    fun calculateSummaryOfMonth(month: Int): Report
    fun calculateIncomesReport(): Report
    fun calculateExpensesReport(): Report
}