fun main() {
  // 1
  println(candy(intArrayOf(1)))
  // 5
  println(candy(intArrayOf(1, 0, 2)))
  // 4
  println(candy(intArrayOf(1, 2, 2)))
  // 7
  println(candy(intArrayOf(1, 3, 2, 2, 1)))
}

private fun candy(ratings: IntArray): Int {
  val n = ratings.size
  if (n <= 1) return n

  val candies = IntArray(n) { 1 }

  for (i in 1 until n) {
    if (ratings[i] > ratings[i - 1]) {
      candies[i] = candies[i - 1] + 1
    }
  }

  for (i in n - 2 downTo 0) {
    if (ratings[i] > ratings[i + 1]) {
      candies[i] = maxOf(candies[i], candies[i + 1] + 1)
    }
  }

  return candies.sum()
}