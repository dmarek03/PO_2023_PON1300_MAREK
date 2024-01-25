fun main(args: Array<String>) {
    val map = BouncyMap(2, 2)
    val animals:List<Animal> = mutableListOf(Animal(Vector2d(0,0)), Animal(Vector2d(0,1)) )
    for(a in animals){
        map.place(a)
    }
    map.place(Animal(Vector2d(0,0)))
    println(map)
    map.place(Animal(Vector2d(0,0)))
    println(map)
    map.place(Animal(Vector2d(0,0)))
    println(map)

    val v1 = Vector2d(3,3)
    val v2 = Vector2d( 3,3)
    val v3 =Vector2d(0,0)
    println(v3 <= v1 && v1 <= v2)
    println(v1 >= v3 && v2 >= v1 )







}