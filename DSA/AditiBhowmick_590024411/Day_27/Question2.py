def count_subarrays(arr, l, r):
    count = 0
    prev_invalid = -1
    prev_valid = -1

    for i in range(len(arr)):
        if arr[i] > r:
            prev_invalid = i

        if l <= arr[i] <= r:
            prev_valid = i
        count += max(0, prev_valid - prev_invalid)

    return count

# User Input
arr = list(map(int, input("Enter the array elements: ").split()))
l = int(input("Enter l: "))
r = int(input("Enter r: "))

print(count_subarrays(arr, l, r))