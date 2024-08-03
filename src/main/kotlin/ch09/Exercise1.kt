package ch09

inline fun <T, R> Iterable<T>.map(transformation: (T) -> R): List<R> {
    val result = ArrayList<R>(if (this is Collection) this.size else 10)

    for (elem in this) {
        result.add(transformation(elem))
    }

    return result
}
