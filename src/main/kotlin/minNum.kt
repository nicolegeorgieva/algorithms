fun main() {
  val nums1 = intArrayOf()
  // null
  println(minNum(nums1))
  val nums2 = intArrayOf(5, 3, 13, 20, 2, 14)
  // 2
  println(minNum(nums2))
}

/**
 * @return the min number or null
 */
private fun minNum(nums: IntArray): Int? {
  if (nums.isEmpty()) return null
  var minNum = nums[0]

  for (i in 1..nums.size - 1) {
    if (nums[i] < minNum) {
      minNum = nums[i]
    }
  }

  return minNum
}