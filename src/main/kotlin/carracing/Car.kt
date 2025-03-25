package carracing

private const val MOVE_THRESHOLD = 4

class Car(private val name: String) {
    init {
        require(name.length <= 5) { "Car name cannot exceed 5 characters." }
    }

    private var position: Int = 0

    fun move(random: Int) {
        if (random >= MOVE_THRESHOLD) {
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
