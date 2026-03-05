fun main() {
//  [24,12,8,6]
  println(productExceptSelf(nums = intArrayOf(1, 2, 3, 4)).joinToString())
}

private fun productExceptSelf(nums: IntArray): IntArray {
  val res = IntArray(nums.size) { 1 }
  var prefix = 1
  for (i in nums.indices) {
    res[i] = prefix
    prefix *= nums[i]
  }

  var suffix = 1
  for (i in nums.indices.reversed()) {
    res[i] *= suffix
    suffix *= nums[i]
  }

  return res
}