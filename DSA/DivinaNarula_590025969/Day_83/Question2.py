# Turn Off the Rightmost Set Bit

def turn_off_rightmost_set_bit(n):
    return n & (n - 1)

n = int(input("Enter a positive integer: "))
result = turn_off_rightmost_set_bit(n)

print("Result:", result)