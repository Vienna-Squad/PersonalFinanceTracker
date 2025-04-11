package storage

import mangers.transaction.TransactionModel
import mangers.transaction.TransactionType
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
                id = newline[0].toInt(),
                date = LocalDate.parse(newline[1]),
                category = newline[2],
                amount = newline[3].toDouble(),
                type = TransactionType.valueOf(newline[4])
            )
            transactions.add(item)
        }
        return transactions
    }

    override fun write(transactions: List<TransactionModel>) {
        val stringBuilderFile: StringBuilder = StringBuilder()
        transactions.forEach { item -> stringBuilderFile.append("$item\n") }
        file.writeText(stringBuilderFile.toString())
    }

}