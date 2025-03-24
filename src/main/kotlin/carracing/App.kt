package carracing

fun main() {
    println("How many cars are in the race?")
    val numCars = readlnOrNull()?.toIntOrNull() ?: 3

    println("How many rounds will be played?")
    val numRounds = readlnOrNull()?.toIntOrNull() ?: 5

    println("Race Results:")
    val race = Race(numCars, numRounds)
    race.start()
}
