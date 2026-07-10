def has_triplet(arr):
    arr.sort()
    n = len(arr)
    for i in range(n - 1, 1, -1):
        left, right = 0, i - 1
        while left < right:
            s = arr[left] + arr[right]
            if s == arr[i]:
                return True
            elif s < arr[i]:
                left += 1
            else:
                right -= 1
    return False

n = int(input("Enter the number of elements: "))
arr = list(map(int, input("Enter the elements: ").split()))
if len(arr) != n:
    print("Invalid input")
else:
    print(has_triplet(arr))