n = int(input("length = "))
arr = [int(input(f"num {i+1} = ")) for i in range(n)]
k = int(input("step = "))
result = arr[-k:] + arr[:-k]
print(result)