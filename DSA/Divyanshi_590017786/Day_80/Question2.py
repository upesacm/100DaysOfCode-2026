def is_power_of_two_or_zero(n):
    return n == 0 or (n & (n - 1)) == 0


n = int(input())
print(is_power_of_two_or_zero(n))