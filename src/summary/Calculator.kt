package summary

import models.Report
import models.Summary
import models.Transaction

interface Calculator {
    fun calculateSummaryOfMonth(month: Int): Summary

    fun calculateReport(): Report
}