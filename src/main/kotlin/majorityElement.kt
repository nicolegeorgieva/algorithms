fun main() {
  // 2
  println(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}

private fun majorityElement(nums: IntArray): Int {
  val numsMap = mutableMapOf<Int, Int>()

  for (num in nums) {
    numsMap[num] = (numsMap[num]?:0) + 1
  }

  return numsMap.maxBy {
    it.value
  }.key
}