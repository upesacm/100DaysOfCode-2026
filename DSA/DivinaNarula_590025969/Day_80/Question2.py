# Power of Two or Zero?

def isPowerOfTwoOrZero(n):
    if n == 0:
        return True

    return (n & (n - 1)) == 0


n = int(input("Enter a non-negative integer: "))

if isPowerOfTwoOrZero(n):
    print("true")
else:
    print("false")