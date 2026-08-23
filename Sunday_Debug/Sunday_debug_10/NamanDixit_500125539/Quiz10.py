class Node:

    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def insert(root, value):

    # If the tree is empty, create a new node.
    if root is None:
        return Node(value)

    # Smaller values go to the LEFT subtree.
    elif value < root.value:
        root.left = insert(root.left, value)

    # Larger values go to the RIGHT subtree.
    elif value > root.value:
        root.right = insert(root.right, value)

    # If value == root.value, do nothing.
    # This prevents duplicate nodes.

    return root


def search(root, target):

    # If we reach an empty position,
    # the value does not exist.
    if root is None:
        return False

    # If the current node contains the target,
    # the value exists.
    if root.value == target:
        return True

    # If target is smaller, search ONLY the left subtree.
    elif target < root.value:
        return search(root.left, target)

    # If target is larger, search ONLY the right subtree.
    else:
        return search(root.right, target)


root = None

gamma_readings = [50, 30, 70, 20, 40, 60, 80]

# Insert all values into the BST.
for reading in gamma_readings:
    root = insert(root, reading)


# Search for 60
print(search(root, 60))

# Search for 25
print(search(root, 25))
