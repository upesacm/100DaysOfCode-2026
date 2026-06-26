def find_first(arr, val):
    lo, hi = 0, len(arr) - 1
    pos = -1

    while lo <= hi:
        mid = (lo + hi) // 2

        if arr[mid] == val:
            pos = mid
            hi = mid - 1  
        elif arr[mid] < val:
            lo = mid + 1
        else:
            hi = mid - 1

    return pos


def find_last(arr, val):
    lo, hi = 0, len(arr) - 1
    pos = -1

    while lo <= hi:
        mid = (lo + hi) // 2

        if arr[mid] == val:
            pos = mid
            lo = mid + 1   
        elif arr[mid] < val:
            lo = mid + 1
        else:
            hi = mid - 1

    return pos


def how_many_times(arr, val):
    start = find_first(arr, val)


    if start == -1:
        return 0

    end = find_last(arr, val)
    return end - start + 1

nums = list(map(int, input("Sorted array (space-separated): ").split()))
val  = int(input("Target: "))

count = how_many_times(nums, val)
print(f"{val} appears {count} time(s)")