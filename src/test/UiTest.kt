package test

import models.TransactionType
import ui.Validator

fun main() {
    //region isValidType
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
    //endregion
    println("====================================================================")
    //region isValidCategoryType
    check(
        name = "when enter an input with just characters return the same string",
        expectedResult = Validator.isValidCategory("home"),
        correctResult = "home"
    )
    check(
        name = "when enter an input with characters and numbers return the same string",
        expectedResult = Validator.isValidCategory("2nd wife"),
        correctResult = "2nd wife"
    )
    check(
        name = "when enter just numbers return null",
        expectedResult = Validator.isValidCategory("45201"),
        correctResult = null
    )
    check(
        name = "when enter an empty string return null",
        expectedResult = Validator.isValidCategory(""),
        correctResult = null
    )
    //endregion

}