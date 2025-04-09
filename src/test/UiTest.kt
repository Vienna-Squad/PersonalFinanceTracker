package test

import ui.Validator

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