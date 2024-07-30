package ch08

inline fun <reified T> Iterable<*>.anyOf() = any { it is T}

inline fun <reified T> Iterable<*>.firstOfOrNull() = firstOrNull { it is T } as? T

inline fun <reified K, reified V> Map<*, *>.filterValuesInstanceOf() =
    filter { it.key is K && it.value is V } as Map<K, V>
