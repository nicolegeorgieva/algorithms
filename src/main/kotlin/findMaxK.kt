fun main() {
  // 3
  println(findMaxK(nums = intArrayOf(-1, 2, -3, 3)))
}

private fun findMaxK(nums: IntArray): Int {
  val negativeNums = hashSetOf<Int>()
  var result = -1

  for (num in nums) {
    if (num < 0) {
      negativeNums.add(num)
    }
  }

  for (num in nums) {
    if (negativeNums.contains(-num) && num > result) {
      result = num
    }
  }

  return result
}