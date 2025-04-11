package storage

import mangers.transaction.TransactionModel

interface Storage {
    fun read(): List<TransactionModel>
    fun write(transactions: List<TransactionModel>)
}