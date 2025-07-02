fun main() {
  val nums = intArrayOf(3, 0, 1)
  // 2
  println(missingNumber(nums))
}

// numbers: 0-n, where n is the count of nums
private fun missingNumber(nums: IntArray): Int {
  var sumOfAll = 0
  var sumOfNums = 0

  for (i in nums.indices) {
    sumOfAll += i
    sumOfNums += nums[i]
  }

  sumOfAll += nums.size

  return sumOfAll - sumOfNums
}