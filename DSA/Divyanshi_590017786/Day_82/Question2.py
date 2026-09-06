def turn_off_rightmost_set_bit(n):
    return n & (n - 1)


n = int(input())
print(turn_off_rightmost_set_bit(n))