package ch06

import kotlin.math.abs

class Centimeter(val value: Double) {
    fun plus(other: Centimeter) = Centimeter(value + other.value)

    fun times(other: Centimeter) = Centimeter(value * other.value)

    override fun toString() = "$value cm"
}

val Int.cm get() = Centimeter(this.toDouble())

fun distance(from: Centimeter, to: Centimeter) = Centimeter(abs(to.value - from.value))

fun main() {
    val foo01: (Centimeter, Centimeter) -> Centimeter = Centimeter::plus
    val foo02: (Centimeter, Centimeter) -> Centimeter = Centimeter::times
    val foo03: (Centimeter) -> Double = Centimeter::value
    val foo04: (Centimeter) -> String = Centimeter::toString
    val foo05: (Centimeter) -> Centimeter = Centimeter(1.0)::plus
    val foo06: (Centimeter) -> Centimeter = Centimeter(2.0)::times
    val foo07: () -> Double = Centimeter(3.0)::value
    val foo08: () -> String = Centimeter(4.0)::toString
    val foo09: (Int) -> Centimeter = Int::cm
    val foo10: () -> Centimeter = 123::cm
    val foo11: (Centimeter, Centimeter) -> Centimeter = ::distance
}
