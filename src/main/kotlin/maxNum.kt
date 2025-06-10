fun main() {
  val nums1 = intArrayOf()
  // null
  println(maxNum(nums1))
  val nums2 = intArrayOf(5, 3, 13, 20, 6, 14)
  // 20
  println(maxNum(nums2))
}

/**
 * @return the max number or null
 */
private fun maxNum(nums: IntArray): Int? {
  if (nums.isEmpty()) return null
  var maxNumber = nums[0]

  for (i in nums.indices) {
    if (i == 0) continue
    if (nums[i] > maxNumber) {
      maxNumber = nums[i]
    }
  }

  return maxNumber
}