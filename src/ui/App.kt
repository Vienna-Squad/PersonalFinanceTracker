package ui

import manager.TransactionManger
import models.Transaction
import models.TransactionType
import toMenuItem
import ui.Validator.isValidAmount
import ui.Validator.isValidCategory
import ui.Validator.isValidId
import ui.Validator.isValidMonthNumber
import ui.Validator.isValidTransactionType

class App(private val transactionManager: TransactionManger) {
    fun start() {
        do {
            MenuItem.entries.forEachIndexed { index, action ->
                println("${index + 1}- ${action.title}")
            }
            print("please choose action *\u001B[33menter (8) or anything else to exit\u001B[0m*: ")
            val selectedAction = (readln().toIntOrNull() ?: -1).toMenuItem()
            println()
            when (selectedAction) {
                MenuItem.ADD -> {
                    val transaction = getTransactionFromUser()
                    if (transaction == null) {
                        println("\u001B[31minvalid input!!\u001B[0m")
                    } else {
                        transactionManager.addTransaction(transaction)
                        println("transaction #${transaction.id} added!!\n")

                    }
                }

                MenuItem.UPDATE -> {
                    val transactionId = getTransactionIdFromUser()
                    if (transactionId == null) {
                        println("\u001B[32minvalid input!!\u001B[0m")
                        return
                    }
                    val oldTransaction = transactionManager.getTransactionById(id = transactionId)
                    if (oldTransaction == null) {
                        println("\u001B[32mtransaction not found!!\u001B[0m")
                    } else {
                        val newTransaction = getUpdatedTransactionFromUser(oldTransaction)
                        if (newTransaction != null) {
                            transactionManager.updateTransaction(newTransaction)
                            println("transaction #$transactionId updated!!\n")
                        } else {
                            println("\u001B[32minvalid input!!\u001B[0m")
                        }
                    }
                }

                MenuItem.DELETE -> {
                    val transactionId = getTransactionIdFromUser()
                    if (transactionId == null) {
                        println("\u001B[32minvalid input!!\u001B[32m")
                    } else {
                        val isDeleted = transactionManager.deleteTransaction(transactionId)
                        if (isDeleted) {
                            println("transaction #$transactionId deleted!!\n")
                        } else {
                            println("\u001B[32mtransaction not found!!\u001B[32m")
                        }
                    }
                }

                MenuItem.VIEW -> {
                    transactionManager.getAllTransactions().forEach {
                        println(it)
                    }
                    println()
                }

                MenuItem.SUMMARY -> {

                }
                MenuItem.INCOMES -> {}
                MenuItem.EXPENSES -> {}
                MenuItem.EXIT -> {}
            }
        } while (selectedAction != MenuItem.EXIT)
    }

    private fun getTransactionFromUser(): Transaction? {
        TransactionType.entries.forEachIndexed { index, transactionType ->
            print("${index + 1}- $transactionType\t")
        }
        print("\nplease enter the transaction type: ")
        var input: String = readln()
        if (!isValidTransactionType(input)) return null
        val type = TransactionType.entries[input.toInt() - 1]
        print("please enter the category of transaction: ")
        input = readln()
        if (!isValidCategory(input)) return null
        val category = input
        print("please enter the amount of transaction: ")
        input = readln()
        if (!isValidAmount(input)) return null
        val amount = input.toDouble()
        return Transaction(amount = amount, category = category, type = type)
    }

    private fun getTransactionIdFromUser(): Int? {
        print("Enter transaction index: ")
        val input = readln()
        if (!isValidId(input)) return null
        return input.toInt()
    }

    private fun getMonthFromUser(): Int? {
        print("Enter the month as a number: ")
        val input = readln()
        if (!isValidMonthNumber(input)) return null
        return input.toInt()
    }

    private fun getUpdatedTransactionFromUser(old: Transaction): Transaction? {
        println("Press Enter to keep the current value.")
        val type = getUpdatedType(old.type) ?: return null
        val category = getUpdatedCategory(old.category) ?: return null
        val amount = getUpdatedAmount(old.amount) ?: return null
        println("\u001B[32mTransaction updated successfully.\u001B[0m")
        return old.copy(category = category, amount = amount, type = type)
    }

    private fun getUpdatedType(old: TransactionType): TransactionType? {
        TransactionType.entries.forEachIndexed { i, type ->
            print("${i + 1}-$type\t")
        }
        print("\nEnter the type number or press Enter to keep current [${old.name}]: ")
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
        print("Enter the new category or press Enter to keep current [${old}]: ")
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
        print("Enter the new amount or press Enter to keep current [${old}]: ")
        val input = readln()
        if (input.isBlank()) {
            return old
        } else {
            val isValid = isValidAmount(input)
            if (!isValid) return null
            return input.toDouble()
        }
    }

}