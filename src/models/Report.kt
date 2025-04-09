package models

data class Report(
    val transactions: List<Transaction> = emptyList(),
    val sum: Double= 0.0,
    val title: String = ""
)