from collections import deque

def cardTrick(n):
    queue = deque(range(1, n + 1))
    result = [0] * n
    positions = deque(range(n))
    
    for card in range(1, n + 1):
        pos = positions.popleft()
        result[pos] = card
        if positions:
            positions.append(positions.popleft())
    
    return result

print(cardTrick(4))
print(cardTrick(5))