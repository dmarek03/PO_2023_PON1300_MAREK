interface WorldMap {
    fun place(animal: Animal)

    fun move(animal: Animal, direction: MoveDirection)

    fun isOccupied(position : Vector2d):Boolean

    fun objectAt(position: Vector2d):Animal?

    fun getElement():Map<Vector2d, Animal>

}