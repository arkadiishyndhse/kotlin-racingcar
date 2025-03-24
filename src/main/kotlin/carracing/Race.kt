package carracing

class Race(
    private val carNames: List<String>,
    private val numRounds: Int,
) {
    private val cars = carNames.map { Car(it) }

    fun start() {
        for (round in 1..numRounds) {
            cars.forEach { it.move() }
            displayRace()
            println()
        }
    }

    private fun displayRace() {
        cars.forEach { car -> println("$car") }
    }
}
