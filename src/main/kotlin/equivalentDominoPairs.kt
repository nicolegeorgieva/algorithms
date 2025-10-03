fun main() {
  val dominoes = arrayOf(intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(3, 4), intArrayOf(5, 6))
  val dominoes2 = arrayOf(intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 1), intArrayOf(1, 2), intArrayOf(2, 2))

  // 1
  println(numEquivDominoPairs(dominoes))
  // 3
  println(numEquivDominoPairs(dominoes2))
}

/*
(a == c && b == d) || (a == d && b == c)
e.g. Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
=> Output: 1
 */
private fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
  val equivPairs = mutableMapOf<IntArray, Int>()
  var index = 0

  while (index < dominoes.size) {
    if (index == dominoes.size - 1) {
      break
    }
    val currentPair = sortPair(dominoes[index])
    if (equivPairs[currentPair] != null) {
      index++
      continue
    }
    for (i in index + 1 until dominoes.size) {
      if (isEqual(currentPair, dominoes[i])) {
        equivPairs[currentPair] = equivPairs[currentPair]?.plus(1) ?: 1
      }
    }
    index++
  }

  return equivPairs.values.sum()
}

private fun isEqual(firstPair: IntArray, secondPair: IntArray): Boolean {
  return firstPair[0] == secondPair[0] && firstPair[1] == secondPair[1] ||
      firstPair[0] == secondPair[1] && firstPair[1] == secondPair[0]
}

private fun sortPair(pair: IntArray): IntArray {
  if (pair.size > 2) return pair
  if (pair[0] == pair[1]) return pair

  return if (pair[0] < pair[1]) {
    pair
  } else {
    intArrayOf(pair[1], pair[0])
  }
}