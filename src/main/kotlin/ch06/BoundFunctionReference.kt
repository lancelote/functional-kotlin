package ch06

data class Number(val num: Int) {
    fun toFloat() = num.toFloat()
    fun times(n: Int) = Number(num * n)
}

fun main() {
    val num = Number(10)

    val getNumAsFloat = num::toFloat
    println(getNumAsFloat())  // 10.0

    val multiplyNum = num::times
    println(multiplyNum(4))  // 40.0
}
