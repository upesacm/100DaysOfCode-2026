n = int(input("length = "))
arr = sorted([int(input(f"num {i+1} = ")) for i in range(n)])
target = int(input("target = "))
result = 0
for i in range(n):
    if arr[i] == target:
        result += 1
print(result)