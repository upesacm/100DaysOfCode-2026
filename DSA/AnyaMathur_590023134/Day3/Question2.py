#number of occurrences problem

def count(arr, target):
    left = 0
    right = len(arr) - 1
    first = -1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == target:
            first = mid
            right = mid - 1
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    if first == -1:
        return 0

    left = 0
    right = len(arr) - 1
    last = -1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == target:
            last = mid
            left = mid + 1
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return last - first + 1


arr = list(map(int, input("Enter sorted array: ").split()))
target = int(input("Enter target: "))

print("Count is ", count(arr, target))