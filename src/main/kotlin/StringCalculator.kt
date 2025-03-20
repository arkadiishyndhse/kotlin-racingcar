class StringCalculator {

    fun calculate(expression: String?): Double {
        validateExpression(expression)

        val tokens = expression!!.split(" ")
        if (tokens.size % 2 == 0) throw IllegalArgumentException("Invalid expression format")

        return computeResult(tokens)
    }

    private fun validateExpression(expression: String?) {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("Input cannot be null or blank")
        }

        if (!expression.matches(Regex("^[0-9]+(\\s[+\\-*/]\\s[0-9]+)*\$"))) {
            throw IllegalArgumentException("Invalid characters in input")
        }
    }

    private fun computeResult(tokens: List<String>): Double {

        var result = tokens[0].toDouble()

        for (i in 1 until tokens.size step 2) {
            val operator = tokens[i]
            val operand = tokens[i + 1].toDouble()

            result = when (operator) {
                "+" -> add(result, operand)
                "-" -> subtract(result, operand)
                "*" -> multiply(result, operand)
                "/" -> divide(result, operand)
                else -> throw IllegalArgumentException("Unsupported operator: $operator")
            }
        }
        return result
    }

    private fun add(a: Double, b: Double) = a + b
    private fun subtract(a: Double, b: Double) = a - b
    private fun multiply(a: Double, b: Double) = a * b
    private fun divide(a: Double, b: Double): Double {
        if (b == 0.0) throw IllegalArgumentException("Division by zero is not allowed")
        return a / b
    }
}