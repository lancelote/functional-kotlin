package ch06

class StudentId(val value: Int)

class UserId(val value: Int) {
    constructor(studentId: StudentId) : this(studentId.value)
}

fun main() {
    val ints = listOf(1, 1, 2, 3, 5, 8)
    val studentIds = ints.map(::StudentId)
    val userIds = studentIds.map(::UserId)
}
