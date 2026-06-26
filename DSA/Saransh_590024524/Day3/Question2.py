arr = list(map(int, input("Enter elements of the array separated by space: ").split()))
n = int(input(("Enter target : ")))
if n < 1 or n > 10 ** 6:
    exit()
if any(i < -10 ** 9 or i > 10 ** 9 for i in arr):
    exit()

count = 0

for i in arr:
    if i == n:
        count +=1

print("The number of appearances: ", count)