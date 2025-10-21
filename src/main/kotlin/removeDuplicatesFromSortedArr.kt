fun main() {
  val arr = intArrayOf(1, 1, 1, 2, 2, 3)
  // 5
  println(removeDuplicates(arr))
  // arr = [1,1,2,2,3,_]
  println(arr.toList().joinToString())
}

private fun removeDuplicates(nums: IntArray): Int {
  var currentNum = nums[0]
  var writeIndex = 1
  var count = 1

  for (i in 1..nums.size - 1) {
    if (nums[i] == currentNum) {
      count++
    } else {
      count = 1
      currentNum = nums[i]
    }

    if (count <= 2) {
      nums[writeIndex] = nums[i]
      writeIndex++
    }
  }

  return writeIndex
}