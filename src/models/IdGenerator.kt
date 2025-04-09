package models

object IdGenerator {
    private var initialValue = 0
    fun setInitialValue(value: Int) {
        initialValue = value
    }

    fun getNextInt(): Int = initialValue++
}