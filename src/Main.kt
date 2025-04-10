import manager.TransactionMangerImpl
import summary.CalculatorImpl
import ui.App

fun main() {
    App(
        transactionManager = TransactionMangerImpl(),
        calculator = CalculatorImpl(),
    ).start()
}




