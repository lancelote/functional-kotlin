package ch09

fun <T : Comparable<T>> List<T>.quickSort(): List<T> {
    if (size <= 1) return this
    val pivot = first()
    val (less, more) = drop(1).partition { it < pivot }
    return less.quickSort() + listOf(pivot) + more.quickSort()
}
