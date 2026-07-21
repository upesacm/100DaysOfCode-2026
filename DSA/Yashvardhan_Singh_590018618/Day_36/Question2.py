from collections import deque

def ticket_counter(n, k):
    q = deque(range(1, n + 1))
    minute = 0

    while q:
        minute += 1
        served = q.popleft()

        
        if served == k:
            return minute

        
        if q and q[0] % 2 == 1:
            q.append(q.popleft())


n = int(input())
k = int(input())

print(ticket_counter(n, k))
