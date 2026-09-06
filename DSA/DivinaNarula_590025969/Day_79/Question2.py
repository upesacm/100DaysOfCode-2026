# The Missing Power of Two

def find_single_number(nums):
    result = 0

    for num in nums:
        result ^= num

    return result


n = int(input("Enter the number of elements: "))
nums = list(map(int, input("Enter the elements: ").split()))

if len(nums) != n:
    print("Please enter exactly", n, "elements.")
else:
    print("Element that appears only once:", find_single_number(nums))