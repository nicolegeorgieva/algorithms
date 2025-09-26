fun main() {

}

/*
(a == c && b == d) || (a == d && b == c)
e.g. Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
=> Output: 1
 */
private fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
  var equivalent = 0
  var index = 0

  while (index < dominoes.size) {
    // TODO
  }

  return equivalent
}

private fun isEqual(firstPair: IntArray, secondPair: IntArray): Boolean {
  return (firstPair[0] == secondPair[0] && firstPair[1] == secondPair[1]) ||
      (firstPair[0] == secondPair[1] && firstPair[1] == secondPair[0])
}