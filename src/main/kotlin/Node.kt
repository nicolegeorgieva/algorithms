fun main() {
  val grandFather = Node("Grandfather")
  val father = Node("Father")
  val uncle = Node("Uncle")

  grandFather.addChild(father)
  grandFather.addChild(uncle)

  val son = Node("Son")
  val daughter = Node("Daughter")
  val cousin = Node("Cousin")

  father.addChild(son)
  father.addChild(daughter)
  uncle.addChild(cousin)

  println(grandFather.toString())

  println("Root: ${grandFather.value}")
  println("Children of ${grandFather.value}:")
  grandFather.children.forEach { child ->
    println("-${child.value}")
    if (child.children.isNotEmpty()) {
      println(" Children of ${child.value}:")
      child.children.forEach { grandChild ->
        println(" -${grandChild.value}")
      }
    }
  }

  println(findNode(root = grandFather, valueToFind = "Father"))
}

class Node<T>(val value: T) {
  val children = mutableListOf<Node<T>>()

  fun addChild(child: Node<T>) {
    children += child
  }

  override fun toString(): String {
    return "Node(value=$value, children=${children.size})"
  }
}

private fun <T> findNode(root: Node<T>, valueToFind: T): Node<T>? {
  if (root.value == valueToFind) return root
  val children = root.children

  for (child in children) {
    val foundNode = findNode(
      root = child,
      valueToFind = valueToFind
    )
    if (foundNode != null) {
      return foundNode
    }
  }

  return null
}