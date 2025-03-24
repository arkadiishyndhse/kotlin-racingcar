package carracing

import kotlin.random.Random

class Car {
    private var position: Int = 0;

    fun move() {
        if(Random.nextInt(10) >= 4) {
            position++
        }
    }

    override fun toString(): String {
        return "-".repeat(position)
    }
}