fun main() {
  // 2
  println(searchInsert(nums = intArrayOf(1, 3, 5, 6), target = 5))
  // 1
  println(searchInsert(nums = intArrayOf(1, 3, 5, 6), target = 2))
  // 4
  println(searchInsert(nums = intArrayOf(1, 3, 5, 6), target = 7))
  // 0
  println(searchInsert(nums = intArrayOf(1, 3, 5, 6), target = 0))
}

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.
 */
private fun searchInsert(nums: IntArray, target: Int): Int {
  for (i in nums.indices) {
    if (i == 0 && nums[i] > target) return 0
    if (nums[i] == target) return i
    if (i == nums.lastIndex) return i + 1
    if (nums[i + 1] > target) return i + 1
  }

  return -1
}