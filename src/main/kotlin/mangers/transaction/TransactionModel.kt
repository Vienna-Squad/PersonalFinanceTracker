package mangers.transaction

import kotlinx.serialization.Serializable
import utils.IdGenerator
import utils.LocalDateSerializer
import java.time.LocalDate

@Serializable
data class TransactionModel(
    val id: Int = IdGenerator.getNextInt(),
    @Serializable(with = LocalDateSerializer::class)
    val date: LocalDate = LocalDate.now(),
    val amount: Double,
    val category: String,
    val type: TransactionType
) {
    override fun toString(): String {
        return "$id | $date | $category | $amount | $type"
    }
}

enum class TransactionType { INCOME, EXPENSE }


