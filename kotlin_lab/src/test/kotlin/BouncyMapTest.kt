import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BouncyMapTest : FunSpec({

    val mapWidth = 5
    val mapHeight = 5

    test("placing an animal on an empty map should add it to the map") {
        val bouncyMap = BouncyMap(mapWidth, mapHeight)
        val animal = Animal()
        bouncyMap.place(animal)

        bouncyMap.isOccupied(animal.getCurrentPosition()) shouldBe true
    }

    test("placing an animal on an occupied position should not add it to the map") {
        val bouncyMap = BouncyMap(mapWidth, mapHeight)
        val animal1 = Animal()
        val animal2 = Animal()
        bouncyMap.place(animal1)
        bouncyMap.place(animal2)

        bouncyMap.isOccupied(animal1.getCurrentPosition()) shouldBe true
        (animal1.getCurrentPosition() == animal2.getCurrentPosition()) shouldBe false
    }

    test("moving an animal should update its position on the map") {
        val bouncyMap = BouncyMap(mapWidth, mapHeight)
        val animal = Animal()
        bouncyMap.place(animal)

        val initialPosition = animal.getCurrentPosition()
        bouncyMap.move(animal, MoveDirection.FORWARD)

        bouncyMap.isOccupied(initialPosition) shouldBe false
        bouncyMap.isOccupied(animal.getCurrentPosition()) shouldBe true
    }

    test("moving an animal outside the map should keep it at the same position") {

        val bouncyMap = BouncyMap(mapWidth, mapHeight)
        val animal = Animal(Vector2d(4, 4))
        bouncyMap.move(animal, MoveDirection.FORWARD)

        bouncyMap.isOccupied(animal.getCurrentPosition()) shouldBe true
        bouncyMap.isOccupied(Vector2d(4, 5)) shouldBe false
    }



})