arr = [1, 2, 2, 2, 3, 3, 4,4 ,4]

def maxOccurrence(arr):
    count = {}
    for num in arr:
        count[num] = count.get(num, 0) + 1
    return max(count, key=count.get)

print(maxOccurrence(arr))