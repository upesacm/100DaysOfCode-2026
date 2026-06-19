def first_occurrence(arr, target):
    left, right = 0, len(arr) - 1
    ans = -1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == target:
            ans = mid
            right = mid - 1
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return ans


def last_occurrence(arr, target):
    left, right = 0, len(arr) - 1
    ans = -1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == target:
            ans = mid
            left = mid + 1
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return ans


arr = list(map(int, input("Enter the sorted array elements: ").split()))
target = int(input("Enter the target element: "))

first = first_occurrence(arr, target)

if first == -1:
    print("Number of occurrences: 0")
else:
    last = last_occurrence(arr, target)
    print("Number of occurrences:", last - first + 1)
