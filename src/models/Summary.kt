package models

data class Summary(
    val listOfTransaction: List<Transaction>,
    val sum: Double,
    val month: String
)
