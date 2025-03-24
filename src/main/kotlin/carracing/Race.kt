package carracing

class Race(
    private val numCars: Int,
    private val numRounds: Int,
) {
    private val cars = List(numCars) { Car() }

    fun start() {
        for (round in 1..numRounds) {
            cars.forEach { it.move() }
            displayRace()
            println()
        }
    }

    private fun displayRace() {
        cars.forEach{ car -> println("$car") }
    }
}