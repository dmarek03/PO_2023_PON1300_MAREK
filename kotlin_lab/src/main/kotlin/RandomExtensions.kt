
fun <T> Map<Vector2d, T>.randomPosition(): Vector2d {
    return keys.toList().random()
}


fun <T> Map<Vector2d, T>.randomFreePosition(mapSize: Vector2d): Vector2d? {
    val allPositions = mutableListOf<Vector2d>()
    for(x in 0..<mapSize.x){
        for(y in 0..<mapSize.y){
            allPositions.add(Vector2d(x, y))
        }
    }

    val occupiedPositions = keys.toList()
    val freePositions = allPositions - occupiedPositions.toSet()

    println("freePositions = $freePositions")
    return freePositions.randomOrNull()
}


