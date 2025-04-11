package storage

import mangers.TranasctionManger.TransactionModel

interface StorageActions {
    fun read(): List<TransactionModel>
    fun write(transactions: List<TransactionModel>)
    fun append(transactionModel: TransactionModel)
}