package carracing

fun main() {
    println("Enter the names of the cars (separated by commas):")
    val carNamesInput = readlnOrNull().orEmpty()
    val carNames = carNamesInput.split(",").map { it.trim() }

    println("How many rounds will be played?")
    val numRounds = readlnOrNull()?.toIntOrNull() ?: 5

    println("Race Results:")
    val race = Race(carNames, numRounds)
    race.start()
}
