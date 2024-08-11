package ch09

fun List<Student>.makePassingStudentsList() =
    filter { it.pointsInSemester > 15 && it.result >= 50 }
        .sortedWith(compareBy({ it.surname }, { it.name }))
        .joinToString(separator = "\n") { "${it.name} ${it.surname}, ${it.result}" }

data class Student(
    val name: String,
    val surname: String,
    val result: Double,
    val pointsInSemester: Int
)
