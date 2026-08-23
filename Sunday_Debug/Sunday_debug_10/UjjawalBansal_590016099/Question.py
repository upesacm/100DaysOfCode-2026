class Node:

    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def insert(root, value):

    # Hulk recovered these lines from different files.
    # Their order may not be correct.

    # Fix 1 -> Base Case appears first
    if root is None:
        return Node(value)
    
    # Fix 2 -> If the value is less than the root's value, it should go to the left subtree
    if value < root.value:
        root.left = insert(root.left, value)    

    # Fix 3 -> If the value is greater than the root's value, it should go to the right subtree
    elif value > root.value:
        root.right = insert(root.right, value)

    # Fix 4 -> Duplicate values should be ignored 

    return root

def search(root, target):
    # Hulk may have moved some lines here too.

    # Fix 5 -> Base case appears first, if the root is None, return False
    if root is None:
        return False

    # Fix 6 -> If the target value is equal to the root's value, return True
    if root.value == target:
        return True

    # Fix 7 -> If the target value is less than the root's value, search in the left subtree
    if target < root.value:
        return search(root.left, target)

    # Fix 8 -> If the target value is greater than the root's value, search in the right subtree
    return search(root.right, target)

root = None

gamma_readings = [50, 30, 70, 20, 40, 60, 80]

for reading in gamma_readings:
    root = insert(root, reading)

print(search(root, 60))
print(search(root, 25))