package calculator

enum class Operator(val symbol: String, val operation: (Double, Double) -> Double) {
    ADD("+", { a, b -> a + b }),
    SUBTRACT("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b ->
        require(b != 0.0) { "Division by zero is not allowed" }
        a / b
    }), ;

    companion object {
        fun fromSymbol(symbol: String): Operator? = entries.find { it.symbol == symbol }
    }
}
