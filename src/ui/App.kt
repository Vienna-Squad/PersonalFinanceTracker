package ui

import manager.TransactionManger
import models.Transaction
import models.TransactionType
import toMenuItem
import ui.Validator.isValidAmount
import ui.Validator.isValidCategory
import ui.Validator.isValidId
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
                        println("added: $transaction\n")
                    }
                }

                MenuItem.UPDATE -> {
                    /*//val transaction = updateTransaction()
                    *//*if (transaction == null) {
                        println("\u001B[32minvalid input!!\u001B[0m")
                    } else {
                        //add
                    }*/
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
                    transactionManager.getAllTransactions()?.forEach {
                        println(it)
                    }
                    println()
                }

                MenuItem.SUMMARY -> {}
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
        print("Enter transaction index to delete: ")
        val input = readln()
        if (!isValidId(input)) return null
        return input.toInt()
    }

    private fun updateTransaction(old: Transaction): Transaction? {
        println("Press Enter to keep the current value.")

        val category = getUpdatedCategory(old.category)
        val amount = getUpdatedAmount(old.amount)
        if (amount == null) {
            println("\u001B[31mFailed to update: Invalid amount after 3 attempts.\u001B[0m")
            return null
        }

        val type = getUpdatedType(old.type)
        if (type == null) {
            println("\u001B[31mFailed to update: Invalid type after 3 attempts.\u001B[0m")
            return null
        }

        println("\u001B[32mTransaction updated successfully.\u001B[0m")
        return old.copy(category = category, amount = amount, type = type)
    }

    private fun getUpdatedCategory(old: String): String {
        while (true) {
            print("New category [$old]: ")
            val input = readln()
            if (input.isBlank()) {
                print("You entered nothing. Keep \"$old\"? (y/n): ")
                if (readln().lowercase() == "y") return old
            } else {
                val isValid = isValidCategory(input)
                if (isValid) return input
                println("\u001B[31mInvalid category. It must not be empty or numeric only.\u001B[0m")
            }
        }
    }

    private fun getUpdatedAmount(old: Double): Double? {
        var attempts = 0
        while (attempts < 3) {
            print("New amount [$old]: ")
            val input = readln()
            if (input.isBlank()) {
                print("You entered nothing. Keep \"$old\"? (y/n): ")
                if (readln().lowercase() == "y") return old else attempts++
            } else {
                val isValid = isValidAmount(input)
                if (isValid) return input.toDouble()
                println("\u001B[31mInvalid amount. Must be a number > 0. [Attempts left: ${2 - attempts}]\u001B[0m")
                attempts++
            }
        }
        return null
    }

    private fun getUpdatedType(old: TransactionType): TransactionType? {
        var attempts = 0
        while (attempts < 3) {
            println("Select new type [${old.name}]:")
            TransactionType.entries.forEachIndexed { i, type ->
                println("${i + 1}. $type")
            }
            print("Enter the type number or press Enter to keep current: ")
            val input = readln()
            if (input.isBlank()) {
                print("You entered nothing. Keep \"$old\"? (y/n): ")
                if (readln().lowercase() == "y") return old else attempts++
            } else {
                val isValid = isValidTransactionType(input)
                if (isValid) return TransactionType.entries[input.toInt() - 1]
                println("\u001B[31mInvalid selection. [Attempts left: ${2 - attempts}]\u001B[0m")
                attempts++
            }
        }
        return null
    }
}