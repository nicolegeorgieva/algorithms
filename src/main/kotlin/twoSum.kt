fun main() {
  // [0,1]
  println(twoSum(nums = intArrayOf(2, 7, 11, 15), target = 9).joinToString())
  // [1,2]
  println(twoSum(nums = intArrayOf(3, 2, 4), target = 6).joinToString())
  // [0,1]
  println(twoSum(nums = intArrayOf(3, 3), target = 6).joinToString())
}

// 1, 8, 2, 5; target: 10
// 1, 2, 5, 8
private fun twoSum(nums: IntArray, target: Int): IntArray {
  var indices = IntArray(size = 2) { -1 }

  var sortedArr = nums.sorted()
  var firstNum = 0
  var secondNum = 0
  var lookFromRightToLeft = false
  var index = 0

  if (target > 5) {
    lookFromRightToLeft = true
    index = sortedArr.lastIndex
  }

  while (indices[0] == -1 && indices[1] == -1) {
    firstNum = sortedArr[index]
    secondNum = target - firstNum
    if (firstNum + secondNum == target && secondNum in sortedArr) {
      indices[0] = nums.indexOf(firstNum)
      if (firstNum == secondNum) {
        nums[nums.indexOf(firstNum)] = -1
      }
      indices[1] = nums.indexOf(secondNum)
    } else {
      if (lookFromRightToLeft) {
        index--
      } else {
        index++
      }
    }
  }

  return indices
}