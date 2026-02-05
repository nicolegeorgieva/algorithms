fun main() {
  // [[-1,-1,2],[-1,0,1]]
  println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
}

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
i != j, i != k, and j != k, and
nums[i] + nums[j] + nums[k] == 0.
 */
private fun threeSum(nums: IntArray): List<List<Int>> {
  val ans = mutableSetOf<List<Int>>()
  nums.sort()

  for (i in 0 until nums.size - 2) {
    var left = i + 1
    var right = nums.size - 1
    while (left < right) {
      val sum = nums[i] + nums[left] + nums[right]

      if (sum == 0) {
        ans.add(listOf(nums[i], nums[left], nums[right]))
        left++
        right--
      } else if (sum < 0) {
        left++
      } else {
        right--
      }
    }
  }
  return ans.toList()
}