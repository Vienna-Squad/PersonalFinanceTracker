package mangers.TranasctionManger

import utils.IdGenerator
import java.time.LocalDate

data class TransactionModel(
    val id: Int = IdGenerator.getNextInt(),
    val date: LocalDate = LocalDate.now(),
    val amount: Double,
    val category: String,
    val type: TransactionType
)

enum class TransactionType { INCOME, EXPENSE }
