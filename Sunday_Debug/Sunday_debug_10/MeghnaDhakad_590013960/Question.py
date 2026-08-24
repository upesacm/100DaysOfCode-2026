class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def insert(root, value):
    # 1. Base case must be first
    if root is None:
        return Node(value)

    # 2. Smaller values go left
    if value < root.value:
        root.left = insert(root.left, value)
        
    # 3. Larger values go right
    elif value > root.value:
        root.right = insert(root.right, value)
        
    # If value == root.value, we do nothing (avoids duplicates)
    
    return root

def search(root, target):
    # 1. Base case: not found
    if root is None:
        return False

    # 2. Base case: found
    if root.value == target:
        return True

    # 3. Utilize BST property to only search one side
    if target < root.value:
        return search(root.left, target)
    else:
        return search(root.right, target)

# Build the tree
root = None
gamma_readings = [50, 30, 70, 20, 40, 60, 80]

for reading in gamma_readings:
    root = insert(root, reading)

# Test searches
print(search(root, 60))
print(search(root, 25))