package ch09

fun <T> Collection<T>.partitions(): Set<Set<Set<T>>> {
    if (isEmpty()) return setOf()
    if (size == 1) return setOf(setOf(setOf(first())))

    val head = first()
    val tailPartitions = drop(1).partitions()

    val alone = tailPartitions
        .map { it + setOf(setOf(head)) }
        .toSet()

    val join = tailPartitions
        .flatMap { partition ->
            partition.map { subset ->
                partition.minusElement(subset).plusElement(subset + head)
            }
        }
        .toSet()

    return alone + join
}
