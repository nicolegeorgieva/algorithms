fun main() {
  // [0,1]
  println(twoSum(nums = intArrayOf(2, 7, 11, 15), target = 9).joinToString())
}

// 1, 8, 2, 5; target: 10
private fun twoSum(nums: IntArray, target: Int): IntArray {
  var indices = IntArray(size = 2) { -1 }
  var sum = 0

  for (i in nums.indices) {
    for (j in nums.indices) {
      if (i == j) continue
      sum = nums[i] + nums[j]
      if (sum == target) {
        indices[0] = i
        indices[1] = j
        return indices
      }
    }
  }

  return indices
}