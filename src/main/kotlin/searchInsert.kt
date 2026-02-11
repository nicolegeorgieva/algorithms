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
  var l = 0
  var r = nums.size - 1

  while (l <= r) {
    val mid = (l + r) / 2
    if (nums[mid] == target) {
      return mid
    } else if (nums[mid] > target) {
      r = mid - 1
    } else {
      l = mid + 1
    }
  }

  return l
}