package utils

fun Int.toMenuItem() = MenuItem.entries.getOrNull(this - 1) ?: MenuItem.EXIT