import ui.MenuItem

fun Int.toMenuItem() = MenuItem.entries.getOrNull(this - 1) ?: MenuItem.EXIT