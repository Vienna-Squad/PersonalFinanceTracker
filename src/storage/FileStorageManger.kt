package storage

import mangers.transaction.TransactionModel
import mangers.transaction.TransactionType
import utils.IdGenerator
import java.io.File
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.time.LocalDate

class FileStorageManger : Storage {

    private val file: File = File("Transaction.txt")

    init {
        if (!file.exists()){
            file.createNewFile()
        }
    }

    override fun read(): List<TransactionModel> {
        if (file.length() == 0L) {
            // Empty file; set default ID
            IdGenerator.setInitialValue(DEFAULT_ID_VALUE)
            return emptyList()
        }

        ObjectInputStream(file.inputStream()).use { input ->
            val transactions = input.readObject() as List<TransactionModel>
            // Set the ID generator to one higher than the last transaction ID
            IdGenerator.setInitialValue(
                transactions.lastOrNull()?.id?.plus(ID_INCREMENT) ?: DEFAULT_ID_VALUE
            )
            return transactions
        }
    }

    override fun write(transactions: List<TransactionModel>) {
        ObjectOutputStream(file.outputStream()).use { output ->
            output.writeObject(transactions)
        }
    }

    companion object {
        private const val ID_INCREMENT = 1
        private const val DEFAULT_ID_VALUE = 0
    }

}