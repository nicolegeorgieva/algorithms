fun main() {
  val nums = intArrayOf(2, 2, 1)
  // 1
  println(singleNumber(nums))
}

// [4,1,2,1,2] -> 4
private fun singleNumber(nums: IntArray): Int {
  val numbersMap = mutableMapOf(
    nums[0] to 1
  )

  for (i in 1..nums.size - 1) {
    if (numbersMap[nums[i]] != null) {
      numbersMap[nums[i]] = numbersMap[nums[i]]?.plus(1)!!
    } else {
      numbersMap.set(key = nums[i], value = 1)
    }
  }

  return numbersMap.entries.find { it.value == 1 }?.key ?: 0
}