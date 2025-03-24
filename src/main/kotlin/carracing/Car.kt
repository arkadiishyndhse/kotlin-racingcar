package carracing

import kotlin.random.Random

class Car(private val name: String) {
    init {
        require(name.length <= 5) { "Car name cannot exceed 5 characters." }
    }

    private var position: Int = 0

    fun move() {
        if (Random.nextInt(10) >= 4) {
            position++
        }
    }

    override fun toString(): String {
        return "$name: " + "-".repeat(position)
    }

    fun getPosition(): Int = position

    fun compareTo(other: Car): Int {
        return this.position.compareTo(other.position)
    }
}
