enum class MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    override fun toString(): String = when (this) {
            NORTH -> "Północ"
            SOUTH -> "Południe"
            EAST -> "Wschód"
            WEST -> "Zachód"
        }


    operator fun next(): MapDirection  = entries[(ordinal + 1) % 4]


    fun previous(): MapDirection = if (ordinal - 1 < 0) { entries[3] } else entries[(ordinal - 1) % 4]








}