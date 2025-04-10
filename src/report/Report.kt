package report

import models.Transaction

data class Report(
    val transactions: List<Transaction> = emptyList(),
    val result: Double= 0.0,
    val title: String = ""
)