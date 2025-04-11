package mangers.transaction


class TransactionManger : Transaction {

    private val transactions = mutableListOf<TransactionModel>()

    override fun addTransaction(transactionModel: TransactionModel): Boolean {
        return transactions.add(transactionModel)
    }

    override fun deleteTransaction(id: Int): Boolean {
        return transactions.removeIf { transactionItem -> transactionItem.id == id }
    }

    override fun updateTransaction(transactionModel: TransactionModel): Boolean {
        val transactionIndex = transactions.indexOfFirst { it.id == transactionModel.id }
        return if (transactionIndex != -1) {
            transactions[transactionIndex] = transactionModel
            true
        } else
            false
    }

    override fun getAllTransactions(): List<TransactionModel> = transactions

    override fun getTransactionById(id: Int): TransactionModel? {
        return transactions.firstOrNull { it.id == id }
    }
}