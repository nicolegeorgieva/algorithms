fun main() {
  val arr1 = intArrayOf(0, 0, 0)
  val arr2 = intArrayOf(2, 5, 6)
  merge(
    nums1 = arr1,
    m = 0,
    nums2 = arr2,
    n = arr2.size,
  )
  println(arr1.joinToString())
}

fun merge(
  nums1: IntArray,
  m: Int,
  nums2: IntArray,
  n: Int,
) {
  if (n == 0) return
  if (m == 0) {
    for (index in nums1.indices) {
      nums1[index] = nums2[index]
    }
    return
  }
  if (m >= n) {
    for (firstArrIndex in nums1.indices) {

    }
  } else {

  }
}