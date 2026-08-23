
class Node:

    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def insert(root, value):

    #Check if root is None BEFORE accessing root.value
    if root is None:
        return Node(value)

    #Smaller values must go to the LEFT
    if value < root.value:
        root.left = insert(root.left, value)

    #Larger values must go to the RIGHT
    elif value > root.value:
        root.right = insert(root.right, value)

    #Duplicate values are ignored
    elif value == root.value:
        return root

    return root


def search(root, target):

    #Check for None BEFORE accessing root.value
    if root is None:
        return False

    #If the value is found, return True
    if root.value == target:
        return True

    #If target is smaller, search ONLY the left subtree
    if target < root.value:
        return search(root.left, target)

    #If target is larger, search ONLY the right subtree
    return search(root.right, target)


root = None

gamma_readings = [50, 30, 70, 20, 40, 60, 80]

for reading in gamma_readings:
    root = insert(root, reading)

print(search(root, 60))
print(search(root, 25))