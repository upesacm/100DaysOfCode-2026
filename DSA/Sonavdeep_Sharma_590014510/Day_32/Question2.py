n = int(input())
st = list(map(int, input().split()))

temp = []
copy = []

while st:
    temp.append(st.pop())

while temp:
    x = temp.pop()
    st.append(x)
    copy.append(x)

print(*copy)