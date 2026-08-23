class Node:

    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def insert(root, value):

    if root is None:
        return Node(value)

    if value < root.value:
        root.left = insert(root.left, value)

    elif value > root.value:
        root.right = insert(root.right, value)

    elif value == root.value:
        return root

    return root


def search(root, target):

    if root is None:
        return False

    if root.value == target:
        return True

    if target < root.value:
        return search(root.left, target)

    return search(root.right, target)


root = None

gamma_readings = [50, 30, 70, 20, 40, 60, 80]

for reading in gamma_readings:
    root = insert(root, reading)

print(search(root, 60))
print(search(root, 25))
