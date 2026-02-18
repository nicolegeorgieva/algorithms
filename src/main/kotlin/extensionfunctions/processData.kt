package extensionfunctions

fun main() {
  val rawData = mapOf(
    "id" to 101,
    "score" to 85,
    "username" to "kotlin_dev"
  )
  println(processData(data = rawData))

  val user = User(first = "Emily", last = "Harris")
  val userMapper = UserMapper()
  val x = with(userMapper) {
    user.map()
  }

  println(x)
}

private fun processData(data: Map<String, Any?>): String {
  val id = data["id"] as? Int ?: return "Invalid or missing ID"
  val score = data["score"] as? Int ?: return "Invalid or missing score"

  val newScore = if (score > 50) score * 2 else score
  println("Print score: $newScore")
  return "User $id scored $score"
}

data class User(val first: String, val last: String)

class UserMapper {
  fun User.map(): User = this.copy(last = last.uppercase())
}