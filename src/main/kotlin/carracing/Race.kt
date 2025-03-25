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

    fun displayWinners() {
        val maxPosition = cars.maxOf { it.getPosition() }
        val winners = cars.filter { it.getPosition() == maxPosition }
        println("\uD83C\uDFC6 Winners: " + winners.joinToString(", ") + " \uD83C\uDFC6")
    }
}
