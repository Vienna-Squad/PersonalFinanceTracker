package utils

enum class MenuItem(val title: String) {
    ADD("Add mangers.transaction"),
    UPDATE("Edit mangers.transaction"),
    DELETE("Delete mangers.transaction"),
    VIEW("Get all mangers.transaction"),
    SUMMARY("Get transactions of the month"),
    INCOMES("Get incomes"),
    EXPENSES("Get expenses"),
    EXIT("Exit"),
}

fun Int.toMenuItem() = MenuItem.entries.getOrNull(this - 1) ?: MenuItem.EXIT