package models

data class Report(
    val listOfIncomes: List<Transaction>,
    val listOfExpenses: List<Transaction>,
    val sumOfIncomes: Double,
    val sumOfExpenses: Double,
)
