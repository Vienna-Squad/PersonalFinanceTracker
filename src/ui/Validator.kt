package ui

import models.TransactionType

object Validator {
    fun isValidType(input: String): TransactionType? {
        val index = input.toIntOrNull() ?: -1
        return TransactionType.entries.getOrNull(index - 1)
    }

    fun isCategoryType(input: String): String? {
        return null
    }

    fun isAmount(input: String): Double? {
        return null
    }

}