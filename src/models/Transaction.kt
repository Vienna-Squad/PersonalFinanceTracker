package models

import java.time.LocalDate

data class Transaction(
    val date: LocalDate = LocalDate.now(),
    val amount: Double,
    val category: String,
    val type: TransactionType
)

enum class TransactionType { INCOME, EXPENSE }
