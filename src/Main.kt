import ui.MenuItem

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


