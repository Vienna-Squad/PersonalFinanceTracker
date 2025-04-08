package managers

import models.Transaction

class TransactionManagerImpl(
    val calculator: ISummaryManager
): TransactionsManager, ISummaryManager by  calculator{

    override fun addTransaction(transaction: Transaction): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteTransaction(transaction: Transaction): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateTransaction(transaction: Transaction): Boolean {
        TODO("Not yet implemented")
    }

    override fun getAllTransaction(): List<Transaction> {
        TODO("Not yet implemented")
    }


}