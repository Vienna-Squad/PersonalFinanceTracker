import ui.MenuItem
import ui.Validator.isValidAmount
import ui.Validator.isValidCategory
import ui.Validator.isValidType
import ui.Validator


fun main() {
    do {
        val selectedAction = showMenuItems()
        when (selectedAction) {
            MenuItem.ADD -> {
                getTransactionFromUser()
            }

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

fun getTransactionIdFromUser(): Int? {
    print("Enter transaction Id to delete:  ")
    val index = Validator.isValidId(readln())
    return index
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

