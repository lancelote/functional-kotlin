package ch05

fun main() {
    val magicSquare = listOf(
        listOf(2, 7, 6),
        listOf(9, 5, 1),
        listOf(4, 3, 8),
    )

    magicSquare.forEach line@{ line ->
        var sum = 0
        line.forEach { element ->
            sum += element
            if (sum == 15) return@line
        }
        println("line $line is not correct")
    }
}
