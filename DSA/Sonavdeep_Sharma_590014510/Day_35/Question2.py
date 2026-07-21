from collections import deque

n = int(input())
k = int(input())

q = deque()

for i in range(1, n + 1):
    q.append(i)

minute = 0

while True:
    person = q.popleft()
    minute += 1

    if person == k:
        print(minute)
        break

    if len(q) > 0:
        if q[0] % 2 == 1:
            x = q.popleft()
            q.append(x)