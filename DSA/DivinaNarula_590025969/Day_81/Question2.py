# The Unique Bit Pattern

def find_unique(nums):
    ones = 0
    twos = 0

    for num in nums:
        ones = (ones ^ num) & ~twos
        twos = (twos ^ num) & ~ones

    return ones


nums = list(map(int, input("Enter the elements: ").split()))

print("Unique element:", find_unique(nums))