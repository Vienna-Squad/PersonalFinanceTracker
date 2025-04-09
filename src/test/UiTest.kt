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
    println("====================================================================")
    //region isValidAmount
    check(
        name = "when enter a decimal positive number return its value",
        expectedResult = Validator.isValidAmount("1400.5"),
        correctResult = 1400.5
    )
    check(
        name = "when enter a negative number return its positive value",
        expectedResult = Validator.isValidAmount("-1500"),
        correctResult = 1500.0
    )
    check(
        name = "when enter a character return null",
        expectedResult = Validator.isValidAmount("a"),
        correctResult = null
    )
    check(
        name = "when enter an empty string return null",
        expectedResult = Validator.isValidAmount(""),
        correctResult = null
    )
    //endregion


fun main() {
    //region Valid input
    // Test 1: Valid input (non-negative integer)
    check(
        "Valid id (0)",
        0,
        Validator.isValidId("0")
    )
    // Test 2: Valid input (non-negative integer)
    check(
        "Valid id (10)",
        10,
        Validator.isValidId("10")
    )
//endregion
    //region Invalid input
    // Test 3: Invalid input (negative number)
    check(
        "Invalid id negative (-1)",
        null,
        Validator.isValidId("-1")
    )

    // Test 4: Invalid input (decimal)
    check(
        "Invalid id decimal (1.5)",
        null,
        Validator.isValidId("1.5")
    )

    // Test 5: Invalid input (empty)
    check(
        "Invalid id blank",
        null,
        Validator.isValidId("")
    )

    // Test 6: Invalid input (spaces only)
    check(
        "Invalid id spaces",
        null,
        Validator.isValidId("  ")
    )

    // Test 7: Invalid input (text)
    check(
        "Invalid id non-numeric (abc)",
        null,
        Validator.isValidId("abc")
    )
    //endregion






}