fun main() {
  val nums = intArrayOf(4, 4, 1, 2, 2)
  // 1
  println(singleNumber(nums))
}

// [4,1,2,1,2] -> 4
private fun singleNumber(nums: IntArray): Int {
  val numbersMap = mutableMapOf<Int, Int>()

  for (n in nums) {
    numbersMap[n] = (numbersMap[n] ?: 0) + 1
  }

  for (entry in numbersMap) {
    if (entry.value == 1) return entry.key
  }

  return 0
}