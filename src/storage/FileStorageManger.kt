package storage

import mangers.transaction.TransactionModel
import mangers.transaction.TransactionType
import utils.IdGenerator
import java.io.File
import java.time.LocalDate

class FileStorageManger : Storage {

    private val file: File = File("Transaction.txt")

    init {
        if (!file.exists()){
            file.createNewFile()
        }
    }
    override fun read(): List<TransactionModel> {
        val transactions = mutableListOf<TransactionModel>()
        file.readLines().forEach { line ->
            val newline = line.split(" | ")
            val item = TransactionModel(
                id = newline[ID_INDEX].toInt(),
                date = LocalDate.parse(newline[DATE_INDEX]),
                category = newline[CATEGORY_INDEX],
                amount = newline[AMOUNT_INDEX].toDouble(),
                type = TransactionType.valueOf(newline[TYPE_INDEX])
            )
            transactions.add(item)
        }
        IdGenerator.setInitialValue(transactions.lastOrNull()?.id?.plus(ID_INCREMENT)?:DEFAULT_ID_VALUE)

        return transactions
    }

    override fun write(transactions: List<TransactionModel>) {
        val stringBuilderFile: StringBuilder = StringBuilder()
        transactions.forEach { item -> stringBuilderFile.append("$item\n") }
        file.writeText(stringBuilderFile.toString())
    }

    companion object {
        private const val ID_INDEX = 0
        private const val DATE_INDEX = 1
        private const val CATEGORY_INDEX = 2
        private const val AMOUNT_INDEX = 3
        private const val TYPE_INDEX = 4

        private const val ID_INCREMENT = 1
        private const val DEFAULT_ID_VALUE = 0
    }

}
