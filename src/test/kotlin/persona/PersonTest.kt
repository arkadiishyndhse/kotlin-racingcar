package person

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `named arguments`() {
        val people =
            listOf(
                Person("Arkadii Shyn", 40, "Arkadii"),
                Person(name = "Arkadii Shyn", nickname = "Arkadii", age = 40),
                Person(nickname = "Arkadii", name = "Arkadii Shyn", age = 40),
            )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("Arkadii Shyn")
            assertThat(it.age).isEqualTo(40)
            assertThat(it.nickname).isEqualTo("Arkadii")
        }
    }

    @Test
    fun `nullable arg`() {
        val person = Person("Arkadii Shyn", null, "Arkadii")
        assertThat(person.age).isNull()
    }

    @Test
    fun `objects equality object`() {
        val person1 = Person("Arkadii Shyn", 40, "Arkadii")
        val person2 = Person("Arkadii Shyn", 40, "Arkadii")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy object`() {
        val person1 = Person("Arkadii Shyn", 40, "Arkadii")
        val person2 = person1.copy(age = null)
        assertThat(person1.age).isEqualTo(40)
        assertThat(person2.age).isNull()
    }
}
