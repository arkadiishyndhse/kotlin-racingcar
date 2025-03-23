package calculator

class StringCalculator {
    fun calculate(expression: String?): Double {
        validateExpression(expression)

        val tokens = expression?.split(" ") ?: emptyList()
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
            val operatorSymbol = tokens[i]
            val operand = tokens[i + 1].toDouble()

            val operator =
                Operator.fromSymbol(operatorSymbol)
                    ?: throw IllegalArgumentException("Unsupported operator: $operatorSymbol")

            result = operator.operation(result, operand)
        }
        return result
    }
}
