import kotlin.math.abs

fun main() {
  // 3
  println(findMaxK(nums = intArrayOf(-1, 2, -3, 3)))
}

private fun findMaxK(nums: IntArray): Int {
  val sortedNums = nums.toSet().sorted()
  var l = 0
  var r = sortedNums.size - 1

  while (l < r) {
    if (sortedNums[r] == abs(sortedNums[l])) return sortedNums[r]
    if (sortedNums[r] > abs(sortedNums[l])) {
      r--
    } else {
      l++
    }
  }

  return -1
}