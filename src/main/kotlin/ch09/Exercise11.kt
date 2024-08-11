package ch09

fun <T> Collection<T>.powerset(): Set<Set<T>> = when {
    isEmpty() -> setOf(setOf())
    else -> {
        val result = drop(1).powerset()
        result + result.map { it + first() }
    }
}

fun main() {
    println(setOf<Int>().powerset()) // [[]]
    println(setOf("A").powerset()) // [[], [A]]
    println(setOf('A', 'B').powerset()) // [[], [B], [A], [B, A]]
    println(setOf(1, 2, 3).powerset())
    // [[], [3], [2], [3, 2], [1], [3, 1], [2, 1], [3, 2, 1]]
    println(setOf(1, 2, 3, 4).powerset())
    // [[], [4], [3], [4, 3], [2], [4, 2], [3, 2], [4, 3, 2], [1], [4, 1], [3, 1], [4, 3, 1], [2, 1], [4, 2, 1], [3, 2, 1], [4, 3, 2, 1]]
}
