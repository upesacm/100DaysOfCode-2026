n=int(input("Enter size: "))
l=[[0]*2 for i in range (n)]
ans=[0]*(n+1)
for i in range(n):
    for j in range(2):
        l[i][j]=int(input(f"Enter [{i}][{j}] th element: "))
for i in range(n):
    a=l[i][0]
    b=l[i][1]
    ans[a]=ans[a]-1
    ans[b]=ans[b]+1
if (max(ans)==n-1):
    print(f"OUTPUT {ans.index(max(ans))}")
else:
    print("OUTPUT -1")


