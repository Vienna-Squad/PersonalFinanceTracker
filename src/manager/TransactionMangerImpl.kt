package manager

import models.Transaction

class TransactionMangerImpl : TransactionManger {
    private val transactions = mutableListOf<Transaction>()
    override fun addTransaction(transaction: Transaction): Boolean {
        return transactions.add(transaction)
    }

    override fun deleteTransaction(id: Int): Boolean {
        return transactions.removeIf { transactionItem -> transactionItem.id == id }
    }

    override fun updateTransaction(transaction: Transaction): Boolean {
        val transactionIndex = transactions.indexOf(transaction)
        return if (transactionIndex != -1) {
            transactions[transactionIndex] = transaction
            true
        } else
            false
    }

    override fun getAllTransactions(): List<Transaction> = transactions

    override fun getTransactionById(id: Int): Transaction? {
        return transactions.firstOrNull { it.id == id }
    }
}