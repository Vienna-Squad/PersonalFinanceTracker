package test

import ui.Validator

fun main() {
    //region isValidType
    check(
        name = "when enter a valid and in range number return the right transaction type",
        expectedResult = Validator.isValidTransactionType("1"),
        correctResult = true
    )
    check(
        name = "when enter an empty string return null",
        expectedResult = Validator.isValidTransactionType(""),
        correctResult = false
    )
    check(
        name = "when enter a negative number return null",
        expectedResult = Validator.isValidTransactionType("-1"),
        correctResult = false
    )
    check(
        name = "when enter an out of range number return null",
        expectedResult = Validator.isValidTransactionType("9"),
        correctResult = false
    )
    check(
        name = "when enter a character return null",
        expectedResult = Validator.isValidTransactionType("a"),
        correctResult = false
    )
    //endregion
    println("====================================================================")
    //region isValidCategoryType
    check(
        name = "when enter an input with just characters return the same string",
        expectedResult = Validator.isValidCategory("home"),
        correctResult = true
    )
    check(
        name = "when enter an input with characters and numbers return the same string",
        expectedResult = Validator.isValidCategory("2nd wife"),
        correctResult = true
    )
    check(
        name = "when enter just numbers return null",
        expectedResult = Validator.isValidCategory("45201"),
        correctResult = false
    )
    check(
        name = "when enter an empty string return null",
        expectedResult = Validator.isValidCategory(""),
        correctResult = false
    )
    //endregion
    println("====================================================================")
    //region isValidAmount
    check(
        name = "when enter a decimal positive number return its value",
        expectedResult = Validator.isValidAmount("1400.5"),
        correctResult = true
    )
    check(
        name = "when enter a negative number return its positive value",
        expectedResult = Validator.isValidAmount("-1500"),
        correctResult = false
    )
    check(
        name = "when enter a character return null",
        expectedResult = Validator.isValidAmount("a"),
        correctResult = false
    )
    check(
        name = "when enter an empty string return null",
        expectedResult = Validator.isValidAmount(""),
        correctResult = false
    )
    //endregion
    //region Valid input
    check(
        "Valid id (0)",
        true,
        Validator.isValidId("0")
    )
    // Test 2: Valid input (non-negative integer)
    check(
        name = "Valid id (10)",
        expectedResult = true,
        correctResult = Validator.isValidId("10")
    )
//endregion
    //region Invalid input
    // Test 3: Invalid input (negative number)
    check(
        name = "Invalid id negative (-1)",
        expectedResult = false,
        correctResult = Validator.isValidId("-1")
    )

    // Test 4: Invalid input (decimal)
    check(
        name = "Invalid id decimal (1.5)",
        expectedResult = false,
        correctResult = Validator.isValidId("1.5")
    )

    // Test 5: Invalid input (empty)
    check(
        name = "Invalid id blank",
        expectedResult = false,
        correctResult = Validator.isValidId("")
    )

    // Test 6: Invalid input (spaces only)
    check(
        name = "Invalid id spaces",
        expectedResult = false,
        correctResult = Validator.isValidId("  ")
    )

    // Test 7: Invalid input (text)
    check(
        name = "Invalid id non-numeric (abc)",
        expectedResult = false,
        correctResult = Validator.isValidId("abc")
    )
    //endregion
}