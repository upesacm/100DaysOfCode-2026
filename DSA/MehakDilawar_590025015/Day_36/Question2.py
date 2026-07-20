#Simulate a ticket counter queue where, after each serve, the new front person moves to the back if their number is odd, 
#and find the minute at which person k gets served.
#Input: n = 4, k = 3. Output: 4.
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
n = int(input("Enter n: "))
k = int(input("Enter k: "))
print(served_minute(n, k))