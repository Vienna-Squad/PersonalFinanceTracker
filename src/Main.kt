import models.Transaction
import models.TransactionType
import ui.MenuItem
import ui.Validator.isValidAmount
import ui.Validator.isValidCategory
import ui.Validator.isValidType
import ui.Validator


fun main() {
    do {
        val selectedAction = showMenuItems()
        when (selectedAction) {
            MenuItem.ADD -> {}
            MenuItem.UPDATE -> {}
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

fun getTransactionFromUser(): Transaction? {
    print("please enter the transaction type: ")
    val type: TransactionType = isValidType(readln()) ?: return null
    print("please enter the category of transaction: ")
    val category: String = isValidCategory(readln()) ?: return null
    print("please enter the amount of transaction: ")
    val amount: Double = isValidAmount(readln()) ?: return null
    return Transaction(amount = amount, category = category, type = type)
}

fun getTransactionIdFromUser(): Int? {
    print("Enter transaction Id to delete: ")
    val index = Validator.isValidId(readln())
    return index
}


/*fun getUpdatedAmount(old: Double): Double? {
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
}*/
