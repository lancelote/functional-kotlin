package ch06

data class Complex(val real: Double, val imaginary: Double) {
    fun double() = Complex(real * 2, imaginary * 2)
    fun times(num: Int) = Complex(real * num, imaginary * num)
}

fun zeroComplex() = Complex(0.0, 0.0)

fun makeComplex(real: Double = 0.0, imaginary: Double = 0.0) = Complex(real, imaginary)

fun Complex.plus(other: Complex) = Complex(real + other.real, imaginary + other.imaginary)

fun Int.toComplex() = Complex(this.toDouble(), 0.0)
