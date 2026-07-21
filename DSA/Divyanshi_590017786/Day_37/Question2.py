from collections import deque

def printer_queue(priorities, location):
    
    q = deque([(i, p) for i, p in enumerate(priorities)])
    minutes = 0

    while q:
        idx, priority = q.popleft()

        
        if any(priority < p for _, p in q):
            q.append((idx, priority))
        else:
            
            minutes += 1

            
            if idx == location:
                return minutes


# Input
priorities = list(map(int, input().split()))
location = int(input())

print(printer_queue(priorities, location))
