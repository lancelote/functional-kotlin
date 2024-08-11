package ch09

val prizes = listOf(5000) + List(3) { 3000 } + List(6) { 1000 }

fun List<Student>.makeBestStudentsList() = this
    .filter { it.pointsInSemester >= 30 && it.result >= 80 }
    .sortedByDescending { it.result }
    .take(10)
    .zip(prizes)
    .sortedWith(compareBy({ (it, _) -> it.surname }, { (it, _) -> it.name }))
    .joinToString(separator = "\n") { (it, prize ) -> "${it.name} ${it.surname}, \$${prize}" }
