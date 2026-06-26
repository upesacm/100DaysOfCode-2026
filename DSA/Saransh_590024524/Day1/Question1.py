num = list(map(int,input("Enter array elements with spacing: ").split()))

for i in range(len(num)):
    if num[i] == 0:
        print("Missing number is: ",i)
        break