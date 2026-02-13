fun main() {
  val root = TreeNode(5)
  root.left = TreeNode(4)
  root.right = TreeNode(8)

  root.left?.left = TreeNode(11)
  root.right?.left = TreeNode(13)
  root.right?.right = TreeNode(4)

  root.left?.left?.left = TreeNode(7)
  root.left?.left?.right = TreeNode(2)
  root.right?.right?.right = TreeNode(1)

  println(
    hasPathSum(
      root = root,
      targetSum = 22
    ),
  )
}

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
  if (root == null) return false
  if (root.left == null && root.right == null) return targetSum == root.`val`
  return hasPathSum(root = root.left, targetSum = targetSum - root.`val`) ||
      hasPathSum(root = root.right, targetSum = targetSum - root.`val`)
}