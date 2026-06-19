def plusOne(digits):
    n = len(digits)

    for i in range(n - 1, -1, -1):
        if digits[i] < 9:
            digits[i] += 1
            return digits

        digits[i] = 0

    return [1] + digits


# Example 1
digits = [1, 2, 3]
print(plusOne(digits))

# Example 2
digits = [4, 3, 2, 1]
print(plusOne(digits))

# Example 3
digits = [9]
print(plusOne(digits))
