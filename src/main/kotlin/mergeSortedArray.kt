fun main() {
  val arr1 = intArrayOf(1, 2, 3, 0, 0, 0)
  val arr2 = intArrayOf(2, 5, 6)
  merge(
    nums1 = arr1,
    m = 3,
    nums2 = arr2,
    n = arr2.size,
  )
  // 1, 2, 2, 3, 5, 6
  println(arr1.joinToString())
}

private fun merge(
  nums1: IntArray,
  m: Int,
  nums2: IntArray,
  n: Int,
) {
  var p1 = m - 1
  var p2 = n - 1
  var pMerged = m + n - 1

  while (p1 >= 0 && p2 >= 0) {
    if (nums1[p1] > nums2[p2]) {
      nums1[pMerged] = nums1[p1]
      p1--
    } else {
      nums1[pMerged] = nums2[p2]
      p2--
    }
    pMerged--
  }

  while (p2 >= 0) {
    nums1[pMerged] = nums2[p2]
    p2--
    pMerged--
  }
}