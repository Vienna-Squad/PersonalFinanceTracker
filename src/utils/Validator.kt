package utils

import mangers.TranasctionManger.TransactionType

object Validator {
    fun isValidTransactionType(input: String): Boolean {
        val index = input.toIntOrNull() ?: -1
        return TransactionType.entries.getOrNull(index - 1) != null
    }

    fun isValidCategory(input: String): Boolean {
        if (input.isEmpty() || input.isBlank()) return false
        if (input.all { it.isDigit() }) return false
        return true
    }

    fun isValidAmount(input: String): Boolean {
        val value = input.toDoubleOrNull() ?: return false
        if (value < 0) return false
        return true
    }

    fun isValidId(id: String): Boolean {
        if (id.isBlank()) {
            return false
        }
        val indexInt = id.toIntOrNull() ?: return false
        return indexInt >= 0
    }

    fun isValidMonthNumber(input: String): Boolean {
        val number = input.toIntOrNull() ?: -1
        return number in 1..12
    }
}