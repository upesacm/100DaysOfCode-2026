class Node:
    
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def insert(root, value):

    # Hulk recovered these lines from different files.
    # Their order may not be correct.
    
    # FIX 1:  Earlier, the code checked value < root.value before checking whether root was None. This could cause an AttributeError for the first insertion. We check root is None first and create a new node when the tree/subtree is empty.
    if root is None:
        return Node(value)
    
    # FIX 2: Earlier, smaller values were incorrectly inserted into the RIGHT subtree. In a BST, smaller values must always go to the LEFT.
    if value < root.value:
        root.left = insert(root.left, value)
    
    # FIX 3: Earlier, larger values were incorrectly inserted into the LEFT subtree. In a BST, larger values must always go to the RIGHT.
    elif value > root.value:
        root.right = insert(root.right, value)
    
    # FIX 4: Earlier, equal values returned Node(value), which created duplicate nodes. BST should not create a new node for duplicate values. Therefore, we simply return the existing root.
    return root

def search(root, target):

    # Hulk may have moved some lines here too.
    
    # FIX 5: Earlier, root.value was checked before checking root is None. This could cause an error when the search reached an empty subtree. If root is None, the target does not exist.
    if root is None:
        return False
    
    # FIX 6: Earlier, finding the target returned False. If the current node contains the target, the search is successful.
    if root.value == target:
        return True
    
    # FIX 7: Earlier, both left and right subtrees were searched. A BST allows us to search only one side using the comparison. If target is smaller, it can only exist in the LEFT subtree.
    if target < root.value:
        return search(root.left, target)
    
    
    # FIX 8: If target is larger, it can only exist in the RIGHT subtree. The previous code incorrectly searched both sides.
    return search(root.right, target)

root = None

gamma_readings = [50, 30, 70, 20, 40, 60, 80]

for reading in gamma_readings:
    root = insert(root, reading)

print(search(root, 60))
print(search(root, 25))