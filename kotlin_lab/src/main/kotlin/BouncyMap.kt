data class BouncyMap(val width:Int, val  height:Int): WorldMap {
    private val animals = mutableMapOf<Vector2d, Animal>()

    private val lowerLeftLimit: Vector2d = Vector2d(0,0)
    private val upperRightLimit: Vector2d = Vector2d(width-1, height-1)
    override fun place(animal: Animal) {
        val currentPosition = animal.getCurrentPosition()
        if (canMoveTo(currentPosition)) {
            if (!isOccupied(currentPosition)) {
                animals[currentPosition] = animal
            } else {
                val nextPosition = animals.randomFreePosition(Vector2d(width, height))
                println("next free position=$nextPosition")

                if (nextPosition != null){
                    animal.currentPosition = nextPosition
                    animals[nextPosition] = animal
                }
                else{

                    val nextNotNullPosition = animals.randomPosition()
                    println("nextNotNullPosition= $nextNotNullPosition")
                    animal.currentPosition = nextNotNullPosition
                    animals[nextNotNullPosition] = animal
                }

            }
        }

    }

    private fun canMoveTo(position: Vector2d):Boolean = (lowerLeftLimit <= position && position <= upperRightLimit)

    override fun move(animal: Animal, direction: MoveDirection){
        animals.remove(animal.getCurrentPosition())
        animal.move(direction)
        animals[animal.getCurrentPosition()] = animal
    }

    override fun isOccupied(position: Vector2d): Boolean = animals.containsKey(position)



    override fun objectAt(position: Vector2d): Animal?  = animals[position]

    override fun toString(): String {
        val visualizer = MapVisualizer(this)
        return visualizer.draw(lowerLeftLimit, upperRightLimit)
    }

    override fun getElement(): Map<Vector2d, Animal> = animals

    fun getLoweLeftLimit() = lowerLeftLimit

    fun getUpperRightLimit() = upperRightLimit


}




