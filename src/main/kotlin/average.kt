fun main() {
  val nums1 = intArrayOf(5, 6, 5)
  // 5.3333335
  println(average(nums1))
  val nums2 = intArrayOf(1, 2, 3)
  // 1.0, 1.5, 2.0
  println(runningAverage(nums2))
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

  var sum = nums[0].toFloat()

  val res = mutableListOf(sum)

  for (i in 1 until nums.size) {
    sum += nums[i]
    res += sum / (i + 1)
  }
  return res
}