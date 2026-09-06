def single_number(arr):
    ones = 0
    twos = 0

    for num in arr:
        ones = (ones ^ num) & ~twos
        twos = (twos ^ num) & ~ones

    return ones


n = int(input())
arr = list(map(int, input().split()))

print(single_number(arr))