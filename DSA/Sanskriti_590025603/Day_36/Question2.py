from collections import deque
n, k = map(int, input().split())
q = deque(range(1, n + 1))
minute = 0
while q:
    person = q.popleft()
    minute += 1

    if person == k:
        print(minute)
        break

    if q and q[0] % 2 == 1:
        q.append(q.popleft())