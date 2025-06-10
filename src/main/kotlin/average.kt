fun main() {
  val nums1 = intArrayOf(5, 6, 5)
  // 5.3333335
  println(average(nums1))
}

fun average(nums: IntArray): Float? {
  if (nums.isEmpty()) return null
  var sum = 0f
  for (i in nums.indices) {
    sum += nums[i]
  }
  return sum / nums.size
}

/**
 * [40, 100, 60]
 *
 * =>
 *
 * [40, 70, 200/3]
 */
fun runningAverage(nums: IntArray): List<Float> {
  if (nums.isEmpty()) return listOf()
  return listOf()
}