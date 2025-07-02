fun main() {
  val nums = intArrayOf(3, 0, 1)
  // 2
  println(missingNumber(nums))
}

// numbers: 0-n, where n is the count of nums
private fun missingNumber(nums: IntArray): Int {
  val numsCount = nums.size
  var actualSum = 0

  for (i in nums.indices) {
    actualSum += nums[i]
  }

  val expectedSum = (numsCount * (numsCount + 1)) / 2

  return expectedSum - actualSum
}