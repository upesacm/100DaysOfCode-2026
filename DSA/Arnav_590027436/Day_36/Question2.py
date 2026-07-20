def find_server_time(n, k):
    queue = list(range(1, n+1))
    minute = 0

    while queue:
        minute += 1
        served = queue.pop(0)

        if served == k:
            return minute
        
        if queue:
            new_front = queue[0]
            if new_front % 2 != 0:
                queue.append(queue.pop(0))
        
    return -1