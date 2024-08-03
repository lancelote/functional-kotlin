package ch09

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.collections.map as `implement it yourself`

class Exercise1Test {
    @Test
    fun mapTests() {
        val numbers = 1..5
        val names = listOf("Mike", "Jane", "Marcin", "John", "James")

        val upper = names.map { it.uppercase() }
        val doubled = numbers.map { it * 2 }

        assertEquals(listOf("MIKE", "JANE", "MARCIN", "JOHN", "JAMES"), upper)
        assertEquals(listOf(2, 4, 6, 8, 10), doubled)

        val list = listOf(1, 2, 3)
        assertEquals(list.map { it * 2 }, listOf(2, 4, 6))
        assertEquals(list.map { "$it!" }, listOf("1!", "2!", "3!"))
        assertEquals(list.map { it % 2 == 0 }, listOf(false, true, false))
    }
}
