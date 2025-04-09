package ui

import models.TransactionType

object Validator {
    fun isValidType(type: TransactionType): Boolean {
        return false
    }

    fun isCategoryType(type: TransactionType): Boolean {
        return false
    }

    fun isAmountType(type: TransactionType): Boolean {
        return false
    }

    fun isValidId(id: String): Int? {
        if (id.isBlank()) {
            return null
        }
        val indexInt = id.toIntOrNull() ?: return null
        if (indexInt < 0) {
            return null
        }
        return indexInt
    }
}