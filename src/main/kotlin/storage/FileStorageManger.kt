package storage

import kotlinx.serialization.json.Json
import mangers.transaction.TransactionModel
import utils.IdGenerator
import java.io.File

class FileStorageManger : Storage {

    private val file: File = File(FILE_NAME)

    init {
        if (!file.exists()) {
            file.createNewFile()
        }
    }

    override fun read(): List<TransactionModel> {
        val content = file.readText()
        if (content.isNotBlank()) {
            val transactions = Json.decodeFromString<List<TransactionModel>>(content)
            IdGenerator.setInitialValue(transactions.lastOrNull()?.id?.plus(1) ?: 0)
            return transactions
        } else {
            return emptyList()
        }

    }

    override fun write(transactions: List<TransactionModel>) {
        file.writeText(Json.encodeToString(transactions))
    }

    companion object {
        private const val FILE_NAME = "Transactions.txt"
    }

}