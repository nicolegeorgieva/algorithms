fun main() {
  val nums1 = intArrayOf()
  // null
  println(maxNumIndex(nums1))
  val nums2 = intArrayOf(5, 3, 13, 20, 6, 14)
  // 3
  println(maxNumIndex(nums2))
}

/**
 * @return the max number or null
 */
private fun maxNumIndex(nums: IntArray): Int? {
  if (nums.isEmpty()) return null
  var maxNumsIndex = 0

  for (i in 1 until nums.size) {
    if (nums[i] > nums[maxNumsIndex]) {
      maxNumsIndex = i
    }
  }

  return maxNumsIndex
}