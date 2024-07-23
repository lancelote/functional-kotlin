package ch05

class Observable<T>(initial: T) {
    private var callbacks: MutableList<(T) -> Unit> = mutableListOf()

    var value: T = initial
        set(value) {
            field = value
            for (callback in callbacks) {
                callback(value)
            }
        }

    fun observe(callback: (T) -> Unit) {
        this.callbacks.add(callback)
    }
}

fun main() {
    val observable = Observable(1)
    println(observable.value) // 1
    observable.observe { println("Changed to $it") }
    observable.value = 2 // Changed to 2
    println(observable.value) // 2
    observable.observe { println("now it is $it") }
    observable.value = 3
    // Changed to 3
    // now it is 3
}
