fun main() {
  // true
  println(
    containsNearbyDuplicate(
      nums = intArrayOf(1, 2, 3, 1),
      k = 3
    )
  )

  // true
  println(
    containsNearbyDuplicate(
      nums = intArrayOf(1, 0, 1, 1),
      k = 1
    )
  )
}

private fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
  val map = HashMap<Int, Int>(nums.size)

  for (i in 0 until nums.size) {
    val j = map.put(nums[i], i)
    if (j != null && i - j <= k) return true
  }

  return false
}