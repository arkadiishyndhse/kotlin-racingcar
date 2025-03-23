import calculator.Operator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OperatorTest {
    @Test
    fun `addition should return correct result`() {
        val result = Operator.ADD.operation(5.0, 3.0)
        assertEquals(8.0, result, 0.0001)
    }

    @Test
    fun `subtraction should return correct result`() {
        val result = Operator.SUBTRACT.operation(10.0, 4.0)
        assertEquals(6.0, result, 0.0001)
    }

    @Test
    fun `multiplication should return correct result`() {
        val result = Operator.MULTIPLY.operation(6.0, 3.0)
        assertEquals(18.0, result, 0.0001)
    }

    @Test
    fun `division should return correct result`() {
        val result = Operator.DIVIDE.operation(9.0, 3.0)
        assertEquals(3.0, result, 0.0001)
    }

    @Test
    fun `division by zero should throw exception`() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Operator.DIVIDE.operation(5.0, 0.0)
            }
        assertEquals("Division by zero is not allowed", exception.message)
    }

    @Test
    fun `fromSymbol should return correct operator`() {
        assertEquals(Operator.ADD, Operator.fromSymbol("+"))
        assertEquals(Operator.SUBTRACT, Operator.fromSymbol("-"))
        assertEquals(Operator.MULTIPLY, Operator.fromSymbol("*"))
        assertEquals(Operator.DIVIDE, Operator.fromSymbol("/"))
    }

    @Test
    fun `fromSymbol should return null for invalid symbols`() {
        assertNull(Operator.fromSymbol("%"))
        assertNull(Operator.fromSymbol("x"))
        assertNull(Operator.fromSymbol("plus"))
    }
}
