package mangers.transaction


interface Transaction {
    fun addTransaction(transactionModel: TransactionModel): Boolean
    fun deleteTransaction(id: Int):Boolean
    fun updateTransaction(transactionModel: TransactionModel): Boolean
    fun getAllTransactions(): List<TransactionModel>
    fun getTransactionById(id: Int): TransactionModel?
    fun saveTransactionsToFileStorage()
}