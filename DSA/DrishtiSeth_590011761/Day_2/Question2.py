arr = [12, 35, 1, 10, 34, 1]

maxi = arr[0]

for i in range(1, len(arr)):
    if arr[i] > maxi:
        maxi = arr[i]

print(maxi)
