package storage

import models.Transaction

interface StorageActions {
    fun read(): List<Transaction>
    fun write(transactions: List<Transaction>)
    fun append(transaction: Transaction)
}