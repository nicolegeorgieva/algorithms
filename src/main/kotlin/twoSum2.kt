fun main() {
  // [1,2]
  println(twoSum2(numbers = intArrayOf(2, 7, 11, 15), target = 9).joinToString())
}

private fun twoSum2(numbers: IntArray, target: Int): IntArray {
  var left = 0
  var right = numbers.size - 1

  while (numbers[left] + numbers[right] != target) {
    if (numbers[left] + numbers[right] > target) {
      right--
    } else {
      left++
    }
  }

  return intArrayOf(left + 1, right + 1)
}