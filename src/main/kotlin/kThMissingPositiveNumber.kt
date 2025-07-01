fun main() {
  val arr = intArrayOf(2, 3, 4, 7, 11)
  // missing -> 1,5,6,8,9,10,12,13,... => 9
  println(findKthPositive(arr = arr, k = 5))

  val arr2 = intArrayOf(1, 2, 3, 4)
  // missing -> 6
  println(findKthPositive(arr = arr2, k = 2))
}

private fun findKthPositive(arr: IntArray, k: Int): Int {
  var missingCount = 0
  var currentNum = 1
  var index = 0

  while (true) {
    if (index < arr.size && arr[index] == currentNum) {
      index++
    } else {
      missingCount++
      if (missingCount == k) {
        return currentNum
      }
    }
    currentNum++
  }
}