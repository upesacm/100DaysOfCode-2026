from collections import deque

n = int(input("Enter the number of people: "))
k = int(input("Enter the person number (k): "))

queue = deque(range(1, n + 1))
minute = 0

while queue:
    person = queue.popleft()
    minute += 1
    if person == k:
        print(minute)
        break

    if queue and queue[0] % 2 != 0:
        queue.append(queue.popleft())