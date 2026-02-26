fun main() {
  // 3
  println(convertTime(current = "02:30", correct = "04:35"))
}

// returns minimum number of operations to convert current to correct
// In one operation you can increase the time current by 1, 5, 15, or 60 minutes
// current <= correct
private fun convertTime(current: String, correct: String): Int {
  val currentMinutes = timeToTotalMinutes(current)
  val correctMinutes = timeToTotalMinutes(correct)

  var diff = correctMinutes - currentMinutes
  var operations = 0

  val increments = intArrayOf(60, 15, 5, 1)

  for (increment in increments) {
    if (diff == 0) break
    operations += diff / increment
    diff %= increment
  }

  return operations
}

private fun timeToTotalMinutes(time: String): Int {
  val (hours, minutes) = time.split(":").map { it.toInt() }
  return (hours * 60) + minutes
}