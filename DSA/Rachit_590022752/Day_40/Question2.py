n = int(input("Enter the number of temperatures: "))

print("Enter the temperatures:")
temperatures = []
for i in range(n):
    temperatures.append(int(input()))

k = int(input("Enter the window size: "))

if k > n or k <= 0:
    print("Invalid window size!")
else:
    print("Highest temperature in every window:")
    
    for i in range(n - k + 1):
        max_temp = temperatures[i]
        for j in range(i + 1, i + k):
            if temperatures[j] > max_temp:
                max_temp = temperatures[j]
        print(max_temp, end=" ")
