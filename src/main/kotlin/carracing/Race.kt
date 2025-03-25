package carracing

import kotlin.random.Random

class Race(
    carNames: List<String>,
    private val numRounds: Int,
) {
    private val cars = carNames.map { Car(it) }

    fun start() {
        for (round in 1..numRounds) {
            cars.forEach { it.move(Random.nextInt(10)) }
            displayRace()
        }
    }

    private fun displayRace() {
        cars.forEach { car -> println("$car") }
    }
}
