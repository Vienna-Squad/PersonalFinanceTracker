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
        ObjectInputStream(file.inputStream()).use { input ->
            return input.readObject() as List<TransactionModel>
        }
    }

    override fun write(transactions: List<TransactionModel>) {
        ObjectOutputStream(file.outputStream()).use { output ->
            output.writeObject(transactions)
        }
    }

}