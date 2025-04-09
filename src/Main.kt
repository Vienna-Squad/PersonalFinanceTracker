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
    print("Enter transaction index to delete: ")
    val input = readln()
    val isValid = Validator.isValidId(input)
    if (!isValid) {
        return null
    }
    return input.toInt()
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

fun getUpdatedCategory(old: String): String {
    while (true) {
        print("New category [$old]: ")
        val input = readln()
        if (input.isBlank()) {
            print("You entered nothing. Keep \"$old\"? (y/n): ")
            if (readln().lowercase() == "y") return old
        } else {
            val parsed = isValidCategory(input)
            if (parsed != null) return parsed
            println("\u001B[31mInvalid category. It must not be empty or numeric only.\u001B[0m")
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
            val parsed = isValidAmount(input)
            if (parsed != null) return parsed
            println("\u001B[31mInvalid amount. Must be a number > 0. [Attempts left: ${2 - attempts}]\u001B[0m")
            attempts++
        }
    }
    return null
}

fun getUpdatedType(old: TransactionType): TransactionType? {
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
            val parsed = isValidType(input)
            if (parsed != null) return parsed
            println("\u001B[31mInvalid selection. [Attempts left: ${2 - attempts}]\u001B[0m")
            attempts++
        }
    }
    return null
}


