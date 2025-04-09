import models.Transaction
import models.TransactionType
import ui.MenuItem
import ui.Validator

fun main() {
    do {
        val selectedAction = showMenuItems()
        when (selectedAction) {
            MenuItem.ADD -> {}
            MenuItem.UPDATE -> {
                val transactionToUpdate = Transaction(
                    //id = 1,
                    amount = 100.0,
                    category = "Salary",
                    type = TransactionType.INCOME
                )

                val updated = updateTransaction(transactionToUpdate)
                if (updated != null) {
                    println("Updated Transaction: $updated")
                }
            }
            MenuItem.DELETE -> {}
            MenuItem.VIEW -> {}
            MenuItem.SUMMARY -> {}
            MenuItem.INCOMES -> {}
            MenuItem.EXPENSES -> {}
            MenuItem.EXIT -> {}
        }
    } while (selectedAction != MenuItem.EXIT)
}

fun showMenuItems(): MenuItem {
    println()
    MenuItem.entries.forEachIndexed { index, action ->
        println("${index + 1}- ${action.title}")
    }
    print("\nplease choose action *\u001B[33menter anything else to exit\u001B[0m*: ")
    val selectedAction = readln().toIntOrNull() ?: -1
    println()
    return selectedAction.toMenuItem()
}

fun getUpdatedCategory(old: String): String {
    while (true) {
        print("New category [$old]: ")
        val input = readln()
        if (input.isBlank()) {
            print("You entered nothing. Keep \"$old\"? (y/n): ")
            if (readln().lowercase() == "y") return old
        } else {
            return input
        }
    }
}

fun getUpdatedAmount(old: Double): Double? {
    var attempts = 0
    while (attempts < 3) {
        print("New amount [$old]: ")
        val input = readln()
        if (input.isBlank()) {
            print("You entered nothing. Keep \"$old\"? (y/n): ")
            if (readln().lowercase() == "y") return old else attempts++
        } else {
            val parsed = input.toDoubleOrNull()
            if (parsed != null && Validator.isAmountValid(parsed)) return parsed
            println("\u001B[31mInvalid amount. Please enter a positive number. [Attempts left: ${2 - attempts}]\u001B[0m")
            attempts++
        }
    }
    return null
}

fun getUpdatedType(old: TransactionType): TransactionType? {
    var attempts = 0
    while (attempts < 3) {
        print("New type (INCOME or EXPENSE) [$old]: ")
        val input = readln()
        if (input.isBlank()) {
            print("You entered nothing. Keep \"$old\"? (y/n): ")
            if (readln().lowercase() == "y") return old else attempts++
        } else {
            try {
                return TransactionType.valueOf(input.uppercase())
            } catch (e: IllegalArgumentException) {
                println("\u001B[31mInvalid type. Please enter INCOME or EXPENSE. [Attempts left: ${2 - attempts}]\u001B[0m")
                attempts++
            }
        }
    }
    return null
}

fun updateTransaction(old: Transaction): Transaction? {
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
