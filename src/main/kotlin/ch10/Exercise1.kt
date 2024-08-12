package ch10

fun m(i: Int): Int {
    print("m$i ")
    return i * i
}

fun f(i: Int): Boolean {
    print("f$i ")
    return i % 2 == 0
}

fun main() {
    val list = listOf(1, 2, 3, 4)

    list.map(::m).filter(::f)  // m$1 m$2 m$3 m$4 f$1 f$4 f$9 f$16
    println()

    list.filter(::f).map(::m)  // f$1 f$2 f$3 f$4 m$2 m$4
    println()

    val sequence = sequenceOf(1, 2, 3, 4)

    sequence.map(::m).filter(::f).toList()  // m$1 f$1 m$2 f$4 m$3 f$9 m$4 f$16
    println()

    sequence.map(::m).filter(::f)           // nothing
    println()

    sequence.map(::m).filter(::f).first()   // m$1 f$1 m$2 f$4
    println()

    sequence.filter(::f).map(::m).toList()  // f$1 f$2 m$2 f$3 f$4 m$4
    println()

    val sequence2 = list.asSequence().map(::m)  // nothing
    println()

    sequence2.toList()                                         // m$1 m$2 m$3 m$4
    println()

    sequence2.filter(::f).toList()                             // m$1 f$1 m$2 f$4 m$3 f$9 m$4 f$16
    println()
}
