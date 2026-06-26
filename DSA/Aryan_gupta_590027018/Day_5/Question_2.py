def pattern(n):
    for i in range(n+1):
        for j in range(i,1):
            print(j,end="")
        print()

pattern(4)       