package ch09

fun List<StudentGrades>.getBestForScholarship(
    semester: String
) = this.filter { student ->
    student.grades.sumOf {
        if (it.semester == semester && it.passing) it.ects else 0
    } > 30
}.sortedByDescending { averageGradeFromSemester(it, semester) }.take(10)

fun averageGradeFromSemester(
    student: StudentGrades, semester: String
) = student.grades.filter { it.semester == semester }.map { it.grade }.average()

data class Grade(
    val passing: Boolean, var ects: Int, var semester: String, var grade: Double
)

data class StudentGrades(
    val studentId: String, val grades: List<Grade>
)
