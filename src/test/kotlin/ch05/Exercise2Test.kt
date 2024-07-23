package ch05

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertEquals

class ObservableTest {

    @Test
    fun `Observable should notify observers`() {
        val observable = Observable(1)
        var notified = false
        observable.observe { notified = true }
        observable.value = 2
        assertTrue(notified)
    }

    @Test
    fun `Observable should notify all observers`() {
        val observable = Observable(1)
        var notified1 = false
        var notified2 = false
        observable.observe { notified1 = true }
        observable.observe { notified2 = true }
        observable.value = 2
        assertTrue(notified1)
        assertTrue(notified2)
    }

    @Test
    fun `Observable should notify observers with new value`() {
        val observable = Observable(1)
        var value = 0
        observable.observe { value = it }
        observable.value = 2
        assertEquals(2, value)
    }
}
