def check_equal_arrays(arr1, arr2):
    # Step 1: Check if the arrays have the same length
    if len(arr1) != len(arr2):
        return False
    # Step 2: Compare corresponding elements
    for i in range(len(arr1)):
        if arr1[i] != arr2[i]:
            return False
    return True
array_a = [1, 2, 34]
array_b = [1, 2, 34]
print(f"Are A and B equal? {check_equal_arrays(array_a, array_b)}") 
