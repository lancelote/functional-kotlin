package ch03

class OnClick : (Int) -> Unit {
    override fun invoke(viewId: Int) {}
}

fun setListener(listener: (Int) -> Unit) {}

fun main() {
    val onClick = OnClick()
    setListener(onClick)
}
