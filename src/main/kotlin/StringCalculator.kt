class StringCalculator {

    private fun validateExpression(expression: String?) {
        if (expression.isNullOrBlank()) {
            throw IllegalArgumentException("Input cannot be null or blank")
        }

        if (!expression.matches(Regex("^[0-9]+(\\s[+\\-*/]\\s[0-9]+)*\$"))) {
            throw IllegalArgumentException("Invalid characters in input")
        }
    }

    private fun add(a: Double, b: Double) = a + b
    private fun subtract(a: Double, b: Double) = a - b
    private fun multiply(a: Double, b: Double) = a * b
    private fun divide(a: Double, b: Double) = a / b

}