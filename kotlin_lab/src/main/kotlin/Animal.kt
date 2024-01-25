class Animal()  {
    private var currentOrientation : MapDirection = MapDirection.NORTH
    internal var currentPosition: Vector2d =  Vector2d(2,2)
        set(value) {
            field = value
        }


    private val upperRightLimit:Vector2d = Vector2d(4, 4)
    private val lowerLeftLimit:Vector2d = Vector2d(0,0)

    constructor(position: Vector2d) : this() {
        this.currentOrientation =MapDirection.NORTH
        this.currentPosition =position
    }


    private fun orientationToString() : String =
        when (this.currentOrientation){
            MapDirection.NORTH -> "^"
            MapDirection.SOUTH -> "v"
            MapDirection.EAST -> ">"
            MapDirection.WEST -> "<"
        }

    override  fun toString():String = orientationToString()

    fun isAt(position: Vector2d) :Boolean = currentPosition == position


    private fun canMoveTo(position: Vector2d):Boolean = (lowerLeftLimit <= position && position <= upperRightLimit)

private fun calculateNextPosition(direction: MoveDirection): Vector2d {
    val unitVector = currentOrientation.toUnitVector()
    return when (direction) {
        MoveDirection.FORWARD -> currentPosition + unitVector
        MoveDirection.BACKWARD -> currentPosition - unitVector
        else -> currentPosition
    }
}
    private fun  MapDirection.toUnitVector(): Vector2d = when (this) {
        MapDirection.NORTH -> Vector2d(0,1)
        MapDirection.SOUTH -> Vector2d(0, -1)
        MapDirection.EAST -> Vector2d(1, 0)
        MapDirection.WEST -> Vector2d(-1, 0)
    }



    fun move(direction: MoveDirection){
        val newPosition: Vector2d = calculateNextPosition(direction)
        if(canMoveTo(newPosition)){
            when(direction){
                MoveDirection.RIGHT -> currentOrientation = currentOrientation.next()
                MoveDirection.LEFT -> currentOrientation = currentOrientation.previous()
                MoveDirection.BACKWARD, MoveDirection.FORWARD -> currentPosition = newPosition
            }
        }

    }



    fun getCurrentOrientation(): MapDirection = currentOrientation

    fun getCurrentPosition():Vector2d = currentPosition








}

