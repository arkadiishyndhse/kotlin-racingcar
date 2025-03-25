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
        displayWinners()
    }

    private fun displayRace() {
        cars.forEach { car -> println("$car") }
    }

    private fun displayWinners() {
        val maxPosition = cars.maxOf { it.getPosition() }
        val winners = cars.filter { it.getPosition() == maxPosition }
        println("\uD83C\uDFC6 Winners: " + winners.joinToString(", ") + " \uD83C\uDFC6")
    }
}
