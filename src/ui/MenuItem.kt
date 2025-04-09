package ui

enum class MenuItem(val title: String) {
    ADD("Add transaction"),
    UPDATE("Edit transaction"),
    DELETE("Delete transaction"),
    VIEW("Get all transaction"),
    SUMMARY("Get transactions of the month"),
    INCOMES("Get incomes"),
    EXPENSES("Get expenses"),
    EXIT("Exit"),
}
