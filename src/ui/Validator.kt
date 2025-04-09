package ui

import models.TransactionType

object Validator {
    fun isValidType(input: String): TransactionType? {
        val index = input.toIntOrNull() ?: -1
        return TransactionType.entries.getOrNull(index - 1)
    }

    fun isValidCategory(input: String): String? {
        if (input.isEmpty() || input.isBlank()) return null
        if (input.all { it.isDigit() }) return null
        return input
    }

    fun isValidAmount(input: String): Double? {
        return null
    }

}