package ch06

class Drone {
    fun setOff() {}
    fun land() {}

    companion object {
        fun makeDrone(): Drone = Drone()
    }
}

fun main() {
    val maker: () -> Drone = Drone.Companion::makeDrone
    val drone = maker()
}
