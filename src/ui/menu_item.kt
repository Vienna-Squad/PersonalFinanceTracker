package ui

enum class MenuItem(val title: String) {
    ADD("Add"),
    UPDATE("Edit transactions"),
    VIEW("get all transaction"),
    DELETE("Delete transaction"),
    SUMMARY("get transaction of the month "),
    INCOMES("get Incomes"),
    EXPENSES("get Expenses"),
    EXIT("Exit");
}
