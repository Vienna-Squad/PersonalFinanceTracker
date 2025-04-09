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


}