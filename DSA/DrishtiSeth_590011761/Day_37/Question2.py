from collections import deque

def printerQueue(priorities, location):

    q = deque()

    for i in range(len(priorities)):
        q.append((priorities[i], i))

    time = 0

    while q:

        current = q.popleft()

        if any(current[0] < item[0] for item in q):
            q.append(current)

        else:
            time += 1

            if current[1] == location:
                return time


print(printerQueue([2,1,3,2],2))
print(printerQueue([1,1,9,1,1,1],0))
print(printerQueue([2,4,3,2,1],2))
