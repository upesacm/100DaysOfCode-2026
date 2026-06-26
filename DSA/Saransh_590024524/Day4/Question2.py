arr = list(map(int,input("Enter elements with space  ").split()))
k = int(input("Enter rotation value  "))

l = len(arr)
temp = []
for i in range(l-k,l):
    temp.append(arr[i])

for i in range(l-k):
    temp.append(arr[i])

print(temp)    