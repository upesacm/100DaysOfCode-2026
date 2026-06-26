s = input("Enter your String :  ")

# rev = s[::-1]
# rev = ''.join(reversed(s))

for i in range(len(s)-1, -1, -1):
    print(s[i], end="")
    