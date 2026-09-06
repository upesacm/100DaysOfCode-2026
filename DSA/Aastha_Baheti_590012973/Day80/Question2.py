def isPowerOfTwo(n):
    return n == 0 or (n & (n - 1)) == 0
print(isPowerOfTwo(0))   # True
print(isPowerOfTwo(18))  # False
print(isPowerOfTwo(8))   # True
print(isPowerOfTwo(16))  # True