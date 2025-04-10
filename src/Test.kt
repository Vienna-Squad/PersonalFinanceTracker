import mangers.TranasctionManger.TransactionModel
import mangers.TranasctionManger.TransactionType
import mangers.report.ReportManger
import mangers.transaction.TransactionManger
import utils.Validator
import java.time.LocalDate


fun <T> check(
    name: String,
    expectedResult: T,
    correctResult: T,
) {
    if (expectedResult == correctResult) {
        println("success - $name")
    } else {
        println("Fail - $name")
    }
}


class Test() {

    fun getUiTest() {
        //region isValidType
        check(
            name = "when enter a valid and in range number return true",
            expectedResult = Validator.isValidTransactionType("1"),
            correctResult = true
        )
        check(
            name = "when enter an empty string return false",
            expectedResult = Validator.isValidTransactionType(""),
            correctResult = false
        )
        check(
            name = "when enter a negative number return false",
            expectedResult = Validator.isValidTransactionType("-1"),
            correctResult = false
        )
        check(
            name = "when enter an out of range number return false",
            expectedResult = Validator.isValidTransactionType("9"),
            correctResult = false
        )
        check(
            name = "when enter a character return false",
            expectedResult = Validator.isValidTransactionType("a"),
            correctResult = false
        )
        //endregion
        println("====================================================================")
        //region isValidCategoryType
        check(
            name = "when enter an input with just characters return true",
            expectedResult = Validator.isValidCategory("home"),
            correctResult = true
        )
        check(
            name = "when enter an input with characters and numbers return true",
            expectedResult = Validator.isValidCategory("2nd wife"),
            correctResult = true
        )
        check(
            name = "when enter just numbers return false",
            expectedResult = Validator.isValidCategory("45201"),
            correctResult = false
        )
        check(
            name = "when enter an empty string return false",
            expectedResult = Validator.isValidCategory(""),
            correctResult = false
        )
        //endregion
        println("====================================================================")
        //region isValidAmount
        check(
            name = "when enter a decimal positive number return true",
            expectedResult = Validator.isValidAmount("1400.5"),
            correctResult = true
        )
        check(
            name = "when enter a negative number return false",
            expectedResult = Validator.isValidAmount("-1500"),
            correctResult = false
        )
        check(
            name = "when enter a character return false",
            expectedResult = Validator.isValidAmount("a"),
            correctResult = false
        )
        check(
            name = "when enter an empty string return false",
            expectedResult = Validator.isValidAmount(""),
            correctResult = false
        )
        //endregion
        println("====================================================================")
        //region isValidMonthNumber
        check(
            name = "when enter a valid month number return true",
            expectedResult = Validator.isValidMonthNumber("5"),
            correctResult = true
        )
        check(
            name = "when enter out of range (1..12) number  return false",
            expectedResult = Validator.isValidMonthNumber("19"),
            correctResult = false
        )
        check(
            name = "when enter character return false",
            expectedResult = Validator.isValidMonthNumber("a"),
            correctResult = false
        )
        check(
            name = "when enter an empty string return false",
            expectedResult = Validator.isValidMonthNumber(""),
            correctResult = false
        )
        //endregion
        println("====================================================================")


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

    fun getReportTest() {

        val dumyData = listOf<TransactionModel>(
            TransactionModel(1, LocalDate.of(2024, 4, 1), 1000.0, "Salary", TransactionType.INCOME),
            TransactionModel(1, LocalDate.of(2024, 4, 2), 200.0, "Gift", TransactionType.INCOME),
            TransactionModel(1, LocalDate.of(2024, 4, 3), 500.0, "Rent", TransactionType.EXPENSE),
            TransactionModel(1, LocalDate.of(2024, 4, 4), 100.0, "Food", TransactionType.EXPENSE)
        )

        val calculatorReport = ReportManger(TransactionManger())


        // Valid TestCase
        check(
            name = ("Check for valid Transaction list Size"),
            expectedResult = calculatorReport.calculateIncomesReport().transactions.size,
            correctResult = 2
        )
        check(
            name = ("Check for valid amount"),
            expectedResult = calculatorReport.calculateIncomesReport().result,
            correctResult = 1200.0
        )
        ////////////////////////////////////////////////////

        // Invalid TestCase

        check(
            name = ("Check for wrong amount"),
            expectedResult = calculatorReport.calculateExpensesReport().result,
            correctResult = 400.0
        )
        check(
            name = ("Check for invalid Transaction list Size"),
            expectedResult = calculatorReport.calculateExpensesReport().transactions.size,
            correctResult = 5
        )

        check(
            name = ("Empty mangers.transaction list"),
            expectedResult = calculatorReport.calculateExpensesReport().transactions.size,
            correctResult = 0,
        )

        val dummytransactions = listOf(
            TransactionModel(
                date = LocalDate.now(),
                amount = 2000.0,
                category = "Monthly Salary",
                type = TransactionType.INCOME
            ), TransactionModel(
                date = LocalDate.now(),
                amount = 1500.0,
                category = "Health",
                type = TransactionType.EXPENSE
            ), TransactionModel(
                date = LocalDate.now(),
                amount = 500.0,
                category = "Freelance",
                type = TransactionType.INCOME
            ), TransactionModel(
                date = LocalDate.now(),
                amount = 500.0,
                category = "Clothes",
                type = TransactionType.EXPENSE
            )
        )
        val calculator = ReportManger(TransactionManger())
//region valid transactions
        check(
            name = "Valid Summary Filtered By Month Transactions ",
            expectedResult = calculator.calculateSummaryOfMonthReport(4).transactions.size,
            correctResult = dummytransactions.size
        )
        check(
            name = "Valid Calculated Balance of Income & Expense ",
            expectedResult = calculator.calculateSummaryOfMonthReport(4).result,
            correctResult = 500.0
        )
//endregion
//region invalid mangers.transaction count of month
        val dummyTransactions2s = listOf(
            TransactionModel(
                date = LocalDate.of(2025, 3, 28),
                amount = 2000.0,
                category = "Monthly Salary",
                type = TransactionType.INCOME
            ), TransactionModel(
                date = LocalDate.now(),
                amount = 1500.0,
                category = "Health",
                type = TransactionType.EXPENSE
            ), TransactionModel(
                date = LocalDate.now(),
                amount = 500.0,
                category = "Freelance",
                type = TransactionType.INCOME
            ), TransactionModel(
                date = LocalDate.now(),
                amount = 500.0,
                category = "Clothes",
                type = TransactionType.EXPENSE
            )
        )

        val calculator2 = ReportManger(TransactionManger())
        //invalid
        check(
            name = "Wrong output of  Filtered By Month Transactions ",
            expectedResult = calculator2.calculateSummaryOfMonthReport(4).transactions.size,
            correctResult = 3
        )
        //endregion

    }

}