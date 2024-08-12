package ch11

data class User(val id: String, val name: String, val points: Int, val category: String)

fun userTable(users: List<User>): TableBuilder = table {
    tr {
        td { +"Id" }
        td { +"Name" }
        td { +"Points" }
        td { +"Category" }
    }
    for (user in users) {
        userRow(user)
    }
}

fun TableBuilder.userRow(user: User) = tr {
    td { +user.id }
    td { +user.name }
    td { +user.points.toString() }
    td { +user.category }
}

fun main() {
    val users = listOf(
        User("1", "Randy", 2, "A"),
        User("4", "Andy", 4, "B"),
        User("3", "Mandy", 1, "C"),
        User("5", "Cindy", 5, "A"),
        User("2", "Lindy", 3, "B"),
    )
     val table = userTable(users)
     println(table)
}
