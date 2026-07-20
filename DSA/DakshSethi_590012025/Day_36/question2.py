from collections import deque

def served_minute(n, k):
    q = deque(range(1, n + 1))
    minute = 0

    while q:
        person = q.popleft()
        minute += 1

        if person == k:
            return minute

        if q and q[0] % 2 == 1:
            q.append(q.popleft())

    return -1

n = int(input("Enter number of people (n): "))
k = int(input("Enter person number (k): "))

print("Minute when person", k, "gets served:", served_minute(n, k))