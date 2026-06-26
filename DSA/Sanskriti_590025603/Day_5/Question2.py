def check_equal_arrays(a, b):
    a.sort()
    b.sort()
    if a == b:
        return True
    return False
a = [1, 2, 5, 4, 0]
b = [2, 4, 5, 0, 1]
print(check_equal_arrays(a, b))