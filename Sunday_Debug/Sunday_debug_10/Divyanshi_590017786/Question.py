class Node:

    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def insert(root, value):

    # If position is empty, create a new node
    if root is None:
        return Node(value)

    # Smaller values go to the left
    if value < root.value:
        root.left = insert(root.left, value)

    # Larger values go to the right
    elif value > root.value:
        root.right = insert(root.right, value)

    # Duplicate values are ignored
    elif value == root.value:
        return root

    return root


def search(root, target):

    # Value not found
    if root is None:
        return False

    # Value found
    if root.value == target:
        return True

    # Search only the appropriate side
    if target < root.value:
        return search(root.left, target)

    return search(root.right, target)


root = None

gamma_readings = [50, 30, 70, 20, 40, 60, 80]

for reading in gamma_readings:
    root = insert(root, reading)

print(search(root, 60))
print(search(root, 25))