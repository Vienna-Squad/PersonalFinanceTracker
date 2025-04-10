import manager.ReportManager
import manager.ReportManagerImp
import manager.TransactionMangerImpl
import summary.Calculator
import summary.CalculatorImpl
import ui.App

fun main() {
    App(
        transactionManager = TransactionMangerImpl(reportManager = ReportManagerImp(calculator = CalculatorImpl())),
    ).start()
}




