package service

import domain.TransactionManager
import model.Transaction


class TransactionManagerImpl : TransactionManager {
    private val transactions = mutableListOf<Transaction>()
    override fun addTransaction(transaction: Transaction) = transactions.add(transaction)
    override fun deleteTransaction(id: Int) = transactions.removeIf { transactionItem -> transactionItem.id == id }
    override fun updateTransaction(transaction: Transaction): Boolean {
        val transactionIndex = transactions.indexOf(transaction)
        return if (transactionIndex != -1) {
            transactions[transactionIndex] = transaction
            true
        } else
            false
    }

    override fun getAllTransactions(): List<Transaction> = transactions
    override fun getTransactionById(id: Int) = transactions.firstOrNull { it.id == id }
}