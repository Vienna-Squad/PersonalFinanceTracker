package mangers.transaction

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
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


