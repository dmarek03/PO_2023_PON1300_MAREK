import java.util.*
import kotlin.math.max
import kotlin.math.min
data class Vector2d(val x: Int, val y: Int) {

    override fun toString(): String = "($x,$y)"

    operator fun compareTo(other: Vector2d): Int =
        when {
            this.x > other.x || (this.x == other.x && this.y > other.y) -> 1
            this.x == other.x && this.y == other.y -> 0
            else -> -1
        }



    operator fun plus(other: Vector2d) : Vector2d  = Vector2d(x + other.x, y + other.y)


    operator fun minus(other: Vector2d): Vector2d = Vector2d(x - other.x, y - other.y)

    operator fun unaryMinus():Vector2d = Vector2d(-x, -y)


    fun upperRight(other: Vector2d): Vector2d  = Vector2d(
            max(x.toDouble(), other.x.toDouble()).toInt(),
            max(y.toDouble(), other.y.toDouble()).toInt()
        )


    fun lowerLeft(other: Vector2d): Vector2d  = Vector2d(
            min(x.toDouble(), other.x.toDouble()).toInt(),
            min(y.toDouble(), other.y.toDouble()).toInt()
        )


    override fun hashCode(): Int = Objects.hash(x, y)


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Vector2d) return false
        return x == other.x && y == other.y
    }



}