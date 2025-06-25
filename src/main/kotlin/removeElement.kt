fun main() {
  val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
  // 5
  println(removeElement(nums = nums, `val` = 2))
  // [0, 1, 3, 0, 4, 0, 4, 2]
  println(nums.toList())
}

private fun removeElement(nums: IntArray, `val`: Int): Int {
  if (nums.isEmpty()) return 0
  var count = 0

  for (i in nums.indices) {
    if (nums[i] != `val`) {
      nums[count] = nums[i]
      count++
    }
  }

  return count
}