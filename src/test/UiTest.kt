package test

import models.TransactionType
import ui.Validator

fun main() {
    check(
        name = "when enter a valid and in range number return the right transaction type",
        expectedResult = Validator.isValidType("1"),
        correctResult = TransactionType.INCOME
    )
    check(
        name = "when enter an empty string return null",
        expectedResult = Validator.isValidType(""),
        correctResult = null
    )
    check(
        name = "when enter a negative number return null",
        expectedResult = Validator.isValidType("-1"),
        correctResult = null
    )
    check(
        name = "when enter an out of range number return null",
        expectedResult = Validator.isValidType("9"),
        correctResult = null
    )
    check(
        name = "when enter a character return null",
        expectedResult = Validator.isValidType("a"),
        correctResult = null
    )

}