package carracing

import io.mockk.every
import io.mockk.mockkObject
import kotlin.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `car should move when random number is 4 or greater`(randomValue: Int) {
        val car = Car("car1")
        mockkObject(Random)
        every { Random.nextInt(10) } returns randomValue
        car.move()
        assertEquals("car1: " + "-", car.toString())
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `car should not move when random number is less than 4`(randomValue: Int) {
        val car = Car("car1")
        mockkObject(Random)
        every { Random.nextInt(10) } returns randomValue

        car.move()
        assertEquals("car1: " + "", car.toString())
    }
}
