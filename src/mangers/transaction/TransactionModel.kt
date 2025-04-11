package mangers.transaction

import utils.IdGenerator
import java.io.Serializable
import java.time.LocalDate

data class TransactionModel(
    val id: Int = IdGenerator.getNextInt(),
    val date: LocalDate = LocalDate.now(),
    val amount: Double,
    val category: String,
    val type: TransactionType
):Serializable {
    override fun toString(): String {
        return "$id | $date | $category | $amount | $type"
    }
}

enum class TransactionType { INCOME, EXPENSE }


