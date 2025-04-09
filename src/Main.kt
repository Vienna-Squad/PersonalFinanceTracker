import models.Transaction
import models.TransactionType
import ui.MenuItem
import ui.Validator.isAmount
import ui.Validator.isCategoryType
import ui.Validator.isValidType

fun main() {
    do {
        val selectedAction = showMenuItems()
        when (selectedAction) {
            MenuItem.ADD -> {
                getTransactionFromUser()
            }

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
    val category: String = isCategoryType(readln()) ?: return null
    print("please enter the amount of transaction: ")
    val amount: Double = isAmount(readln()) ?: return null
    return Transaction(amount = amount, category = category, type = type)
}


