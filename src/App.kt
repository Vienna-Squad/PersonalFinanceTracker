import mangers.transaction.TransactionModel
import mangers.transaction.TransactionType
import mangers.report.Report
import mangers.report.ReportManger
import mangers.transaction.Transaction
import mangers.report.ReportModel
import mangers.transaction.TransactionManger
import storage.FileStorageManger
import utils.MenuItem
import utils.Validator.isValidAmount
import utils.Validator.isValidCategory
import utils.Validator.isValidId
import utils.Validator.isValidMonthNumber
import utils.Validator.isValidTransactionType
import utils.toMenuItem

class App {

    private val fileStorage = FileStorageManger()
    private val transactionManager: Transaction = TransactionManger(fileStorage)
    private val reportManger: Report = ReportManger(transactionManager)

    fun start() {
        do {
            MenuItem.entries.forEachIndexed { index, action ->
                println("${index + 1}- ${action.title}")
            }
            print("choose the action \u001B[33m*enter (8) or anything else to exit*\u001B[0m: ")
            val selectedAction = (readln().toIntOrNull() ?: -1).toMenuItem()
            println()
            when (selectedAction) {
                MenuItem.ADD -> {
                    val transaction = getTransactionFromUser()
                    if (transaction == null) {
                        printRedText("invalid input!!\n")
                    } else {
                        transactionManager.addTransaction(transaction)
                        printGreenText("#${transaction.id} transaction added!!\n")

                    }
                }

                MenuItem.UPDATE -> {
                    val transactionId = getTransactionIdFromUser()
                    if (transactionId == null) {
                        printRedText("invalid input!!\n")
                        return
                    }
                    val oldTransaction = transactionManager.getTransactionById(id = transactionId)
                    if (oldTransaction == null) {
                        printRedText("transaction not found!!\n")
                    } else {
                        val newTransaction = getUpdatedTransactionFromUser(oldTransaction)
                        if (newTransaction != null) {
                            transactionManager.updateTransaction(newTransaction)
                            printGreenText("#$transactionId transaction updated!!\n")
                        } else {
                            printRedText("invalid input!!\n")
                        }
                    }
                }

                MenuItem.DELETE -> {
                    val transactionId = getTransactionIdFromUser()
                    if (transactionId == null) {
                        printRedText("invalid input!!\n")
                    } else {
                        val isDeleted = transactionManager.deleteTransaction(transactionId)
                        if (isDeleted) {
                            printGreenText("#$transactionId transaction  deleted!!\n")
                        } else {
                            printRedText("transaction not found!!\n")
                        }
                    }
                }

                MenuItem.VIEW -> {

                    transactionManager.getAllTransactions().forEach {
                        printBlueText(it.toString())
                    }
                    println()
                }

                MenuItem.SUMMARY -> {
                    val monthNumber = getMonthFromUser()
                    if (monthNumber == null) {
                        printRedText("invalid input!!\n")
                    } else {
                        val report = reportManger.generateSummaryOfMonthReport(monthNumber)
                        printReport(report)
                    }
                }

                MenuItem.INCOMES -> {
                    val report = reportManger.calculateIncomesReport()
                    printReport(report)
                }

                MenuItem.EXPENSES -> {
                    val report = reportManger.generateExpensesReport()
                    printReport(report)
                }

                MenuItem.EXIT -> {}
            }
        } while (selectedAction != MenuItem.EXIT)
        print("Your Transactions added to File")
        transactionManager.saveTransactionsToFileStorage()
    }

    private fun getTransactionFromUser(): TransactionModel? {
        TransactionType.entries.forEachIndexed { index, transactionType ->
            print("${index + 1}- $transactionType\t")
        }
        print("\nenter the transaction type: ")
        var input: String = readln()
        if (!isValidTransactionType(input)) return null
        val type = TransactionType.entries[input.toInt() - 1]
        print("enter the category of transaction: ")
        input = readln()
        if (!isValidCategory(input)) return null
        val category = input
        print("enter the amount of transaction: ")
        input = readln()
        if (!isValidAmount(input)) return null
        val amount = input.toDouble()
        return TransactionModel(amount = amount, category = category, type = type)
    }

    private fun getTransactionIdFromUser(): Int? {
        print("enter transaction index: ")
        val input = readln()
        if (!isValidId(input)) return null
        return input.toInt()
    }

    private fun getMonthFromUser(): Int? {
        print("enter the month as a number: ")
        val input = readln()
        if (!isValidMonthNumber(input)) return null
        return input.toInt()
    }

    private fun getUpdatedTransactionFromUser(old: TransactionModel): TransactionModel? {
        val type = getUpdatedType(old.type) ?: return null
        val category = getUpdatedCategory(old.category) ?: return null
        val amount = getUpdatedAmount(old.amount) ?: return null
        return old.copy(category = category, amount = amount, type = type)
    }

    private fun getUpdatedType(old: TransactionType): TransactionType? {
        TransactionType.entries.forEachIndexed { i, type ->
            print("${i + 1}-$type\t")
        }
        print("\nenter the type number or \u001B[33mpress (Enter) to keep current [${old.name}]\u001B[0m: ")
        val input = readln()
        if (input.isBlank()) {
            return old
        } else {
            val isValid = isValidTransactionType(input)
            if (!isValid) return null
            return TransactionType.entries[input.toInt() - 1]
        }
    }

    private fun getUpdatedCategory(old: String): String? {
        print("enter the new category or \u001B[33mpress (Enter) to keep current [${old}]\u001B[0m: ")
        val input = readln()
        if (input.isBlank()) {
            return old
        } else {
            val isValid = isValidCategory(input)
            if (!isValid) return null
            return input
        }
    }

    private fun getUpdatedAmount(old: Double): Double? {
        print("enter the new amount or \u001B[33mpress (Enter) to keep current [${old}]\u001B[0m: ")
        val input = readln()
        if (input.isBlank()) {
            return old
        } else {
            val isValid = isValidAmount(input)
            if (!isValid) return null
            return input.toDouble()
        }
    }

    private fun printReport(report: ReportModel) {
        if (report.transactions.isNotEmpty()) {
            printBlueText("title: ${report.title}\ntotal: ${report.result}")
            report.transactions.forEach {
                printBlueText("$it")
            }
            println()
        } else {
            printRedText("no transactions at this month!!\n")
        }
    }


    private fun printGreenText(text: String) {
        println("\u001B[32m$text\u001B[0m")
    }

    private fun printRedText(text: String) {
        println("\u001B[31m$text\u001B[0m")
    }

    private fun printBlueText(text: String) {
        println("\u001B[34m$text\u001B[0m")
    }

}


