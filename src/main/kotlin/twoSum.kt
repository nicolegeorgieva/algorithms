fun main() {
  // [0,1]
  println(twoSum(nums = intArrayOf(2, 7, 11, 15), target = 9).joinToString())
  // [1,2]
  println(twoSum(nums = intArrayOf(3, 2, 4), target = 6).joinToString())
  // [0,1]
  println(twoSum(nums = intArrayOf(3, 3), target = 6).joinToString())
}

// 1, 8, 2, 5; target: 10
private fun twoSum(nums: IntArray, target: Int): IntArray {
  var indices = IntArray(size = 2) { -1 }
  val numsMap = mutableMapOf<Int, Int>()

  for (i in nums.indices) {
    numsMap[nums[i]] = i
  }

  for (i in nums.indices) {
    val secondNum = target - nums[i]
    val secondNumIndex = numsMap[secondNum]

    if (secondNumIndex != null && secondNumIndex != i) {
      indices[0] = i
      indices[1] = secondNumIndex
      return indices
    }
  }

  return indices
}