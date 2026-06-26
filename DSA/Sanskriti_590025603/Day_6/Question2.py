def union_arrays(a, b):
    result = []
    for num in a:
        if num not in result:
            result.append(num)
    for num in b:
        if num not in result:
            result.append(num)
    result.sort()
    return result
a = [1, 2, 3, 4, 5]
b = [1, 2, 3, 6, 7]
print(union_arrays(a, b))