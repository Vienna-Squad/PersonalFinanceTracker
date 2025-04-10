package mangers.report

import mangers.TranasctionManger.TransactionModel

data class ReportModel(
    val transactions: List<TransactionModel> = emptyList(),
    val result: Double= 0.0,
    val title: String = ""
)