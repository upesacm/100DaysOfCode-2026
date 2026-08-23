class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


class BST:
    def __init__(self):
        self.root = None

    def insert(self, root, value):
        if root is None:
            return Node(value)

        if value < root.data:
            root.left = self.insert(root.left, value)

        elif value > root.data:
            root.right = self.insert(root.right, value)

        return root

    def search(self, root, value):
        if root is None:
            return False

        if root.data == value:
            return True

        if value < root.data:
            return self.search(root.left, value)

        return self.search(root.right, value)

    def add(self, value):
        self.root = self.insert(self.root, value)

    def find(self, value):
        return self.search(self.root, value)


tree = BST()

tree.add(50)
tree.add(30)
tree.add(70)
tree.add(20)
tree.add(40)
tree.add(60)
tree.add(80)

print(tree.find(40))
print(tree.find(90))
