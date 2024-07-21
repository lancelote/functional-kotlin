package ch05

fun makeCounter(): () -> Int {
    var i = 0
    return { i++ }
}

fun main() {
    val counter1 = makeCounter()
    val counter2 = makeCounter()

    println(counter1())
    println(counter1())
    println(counter2())
    println(counter1())
    println(counter1())
    println(counter2())
}
