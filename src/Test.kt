import mangers.transaction.TransactionModel
import mangers.transaction.TransactionType
import mangers.report.ReportManger
import mangers.transaction.TransactionManger
import utils.Validator
import java.time.LocalDate


fun <T> check(
    name: String,
    expectedResult: T,
    correctResult: T,
) :Boolean{
    if (expectedResult == correctResult) {
        println("\u001B[32msuccess - $name\u001B[0m")
        return true
    } else {
        println("\u001B[31mFail - $name\u001B[0m")
        return false
    }
}

class Test {
    companion object {
        fun run() :Boolean{
            //region isValidTransactionType
            var test=true
           if (! check(
                name = "when enter a valid and in range number return true",
                expectedResult = Validator.isValidTransactionType("1"),
                correctResult = true
            )){
               test=false}

            if (! check(
                name = "when enter an empty string return false",
                expectedResult = Validator.isValidTransactionType(""),
                correctResult = false
                )){
                test=false}
            if (!check (
                name = "when enter a negative number return false",
                expectedResult = Validator.isValidTransactionType("-1"),
                correctResult = false
                )){
                test=false}
            if (!check(
                name = "when enter an out of range number return false",
                expectedResult = Validator.isValidTransactionType("9"),
                correctResult = false
                )){
                test=false}
            if(!check(
                name = "when enter a character return false",
                expectedResult = Validator.isValidTransactionType("a"),
                correctResult = false
                )){test=false}
            //endregion
            //region isValidCategory
            if(!check(
                name = "when enter an input with just characters return true",
                expectedResult = Validator.isValidCategory("home"),
                correctResult = true
                )){test=false}
            if(! check(
                name = "when enter an input with characters and numbers return true",
                expectedResult = Validator.isValidCategory("2nd wife"),
                correctResult = true
                )){test=false}
            if(!check(
                name = "when enter just numbers return false",
                expectedResult = Validator.isValidCategory("45201"),
                correctResult = false
                )){test=false}
            if(!check(
                name = "when enter an empty string return false",
                expectedResult = Validator.isValidCategory(""),
                correctResult = false
                )){test=false}
            //endregion
            //region isValidAmount
            if(!check(
                name = "when enter a decimal positive number return true",
                expectedResult = Validator.isValidAmount("1400.5"),
                correctResult = true
                )){test=false}
            if(!check(
                name = "when enter a negative number return false",
                expectedResult = Validator.isValidAmount("-1500"),
                correctResult = false
                )){test=false}
            if(!check(
                name = "when enter a character return false",
                expectedResult = Validator.isValidAmount("a"),
                correctResult = false
                )){test=false}
            if(!check(
                name = "when enter an empty string return false",
                expectedResult = Validator.isValidAmount(""),
                correctResult = false
                )){test=false}
            //endregion
            //region isValidMonthNumber
            if(!check(
                name = "when enter a valid month number return true",
                expectedResult = Validator.isValidMonthNumber("5"),
                correctResult = true
                )){test=false}
            if(!check(
                name = "when enter out of range (1..12) number  return false",
                expectedResult = Validator.isValidMonthNumber("19"),
                correctResult = false
                )){test=false}
            if(!check(
                name = "when enter character return false",
                expectedResult = Validator.isValidMonthNumber("a"),
                correctResult = false
                )){test=false}
            if(!check(
                name = "when enter an empty string return false",
                expectedResult = Validator.isValidMonthNumber(""),
                correctResult = false
                )){test=false}
            //endregion
            //region isValidId
            if(!check(
                "Valid id (0)",
                true,
                Validator.isValidId("0")
                )){test=false}
            if(! check(
                name = "Valid input (non-negative integer),Valid id (10)",
                expectedResult = true,
                correctResult = Validator.isValidId("10")
                )){test=false}
            if(! check(
                name = "Invalid input (negative number), Invalid id negative (-1)",
                expectedResult = false,
                correctResult = Validator.isValidId("-1")
                )){test=false}
            if(!check(
                name = "Invalid input (decimal), Invalid id decimal (1.5)",
                expectedResult = false,
                correctResult = Validator.isValidId("1.5")
                )){test=false}
            if(!check(
                name = "Invalid input (empty), Invalid id blank",
                expectedResult = false,
                correctResult = Validator.isValidId("")
                )){test=false}
            if(!check(
                name = "Invalid input (spaces only), Invalid id spaces",
                expectedResult = false,
                correctResult = Validator.isValidId("  ")
                )){test=false}
            if(! check(
                name = "Invalid input (text), Invalid id non-numeric (abc)",
                expectedResult = false,
                correctResult = Validator.isValidId("abc")
                )){test=false}
            //endregion
            //region calculateIncomesReport
            val calculatorReport = ReportManger(TransactionManger())
            if(! check(
                name = ("Check for valid Transaction list Size"),
                expectedResult = calculatorReport.calculateIncomesReport().transactions.size,
                correctResult = 2
                )){test=false}
            if(! check(
                name = ("Check for valid amount"),
                expectedResult = calculatorReport.calculateIncomesReport().result,
                correctResult = 1200.0
                )){test=false}
            //endregion
            //region generateExpensesReport
            if(! check(
                name = ("Check for wrong amount"),
                expectedResult = calculatorReport.generateExpensesReport().result,
                correctResult = 400.0
                )){test=false}
            if(!  check(
                name = ("Check for invalid Transaction list Size"),
                expectedResult = calculatorReport.generateExpensesReport().transactions.size,
                correctResult = 5
                )){test=false}
            if(!check(
                name = ("Empty mangers.transaction list"),
                expectedResult = calculatorReport.generateExpensesReport().transactions.size,
                correctResult = 0,
                )){test=false}
            //endregion
            //region generateSummaryOfMonthReport
            val dummyTransactions = listOf(
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
            if(! check(
                name = "Valid Summary Filtered By Month Transactions ",
                expectedResult = calculator.generateSummaryOfMonthReport(4).transactions.size,
                correctResult = dummyTransactions.size
                )){test=false}
            if(! check(
                name = "Valid Calculated Balance of Income & Expense ",
                expectedResult = calculator.generateSummaryOfMonthReport(4).result,
                correctResult = 500.0
                )){test=false}
            val calculator2 = ReportManger(TransactionManger())
            if(! check(
                name = "Wrong output of  Filtered By Month Transactions ",
                expectedResult = calculator2.generateSummaryOfMonthReport(4).transactions.size,
                correctResult = 3
            )){test=false}
            //endregion
            //region updateTransaction
            var isNotValidUpdateTransaction = true
            val transactionModelTest = TransactionModel(
                id = 1,
                date = LocalDate.now(),
                amount = 1200.0,
                category = "Salary",
                type = TransactionType.INCOME
            )
            val transactionMangerTest = TransactionManger()
            transactionMangerTest.addTransaction(transactionModelTest)

            if (transactionModelTest !in transactionMangerTest.getAllTransactions())
                isNotValidUpdateTransaction = false
            if(! check(
                name = "when transaction model is in the list of transactions should return false",
                expectedResult = transactionMangerTest.updateTransaction(transactionModelTest),
                correctResult = isNotValidUpdateTransaction
            )){test=false}
            //endregion

        return test
        }

    }
}