package storage

import mangers.transaction.TransactionModel

interface StorageActions {
    fun read(): List<TransactionModel>
    fun write(transactions: List<TransactionModel>)
    fun append(transactionModel: TransactionModel)
}