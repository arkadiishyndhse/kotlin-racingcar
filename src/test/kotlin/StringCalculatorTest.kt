import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource


class StringCalculatorTest {
    private val calculator = StringCalculator()

    @Test
    fun `full expression example should calculate correctly`() {
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10.0)
    }

    @Test
    fun `division by zero should throw IllegalArgumentException`() {
        assertThatThrownBy { calculator.calculate("10 / 0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Division by zero is not allowed")
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 + ", "5 - ", "* 3 4", "10 / * 2"])
    fun `invalid expression format should throw exception`(expression: String) {
        assertThatThrownBy { calculator.calculate(expression) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid characters in input")
    }


    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `null or blank input should throw exception`(expression: String) {
        assertThatThrownBy { calculator.calculate(expression) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Input cannot be null or blank")
    }

    @ParameterizedTest(name = "Calculating: {0} = {1}")
    @CsvSource(
        "2 + 3, 5.0",
        "10 - 4, 6.0",
        "4 * 5, 20.0",
        "20 / 5, 4.0",
        "2 + 3 * 4, 20.0",
        "100 / 2 * 3, 150.0",
        "5 - 2 + 8, 11.0",
        "1 + 1 + 1 + 1, 4.0",
        "10 - 3 - 2, 5.0",
        "8 / 2 * 2, 8.0"
    )
    fun `test valid arithmetic expressions`(expression: String, expectedResult: Double) {
        assertThat(calculator.calculate(expression)).isEqualTo(expectedResult)
    }

}