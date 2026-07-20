from collections import deque

def ticket_counter(n: int, k: int) -> int:
    """
    Simulates a ticket counter queue of people numbered 1..n.
    Each minute, the front person is served. After serving, if the
    new front person's number is odd, they move to the back instead
    of being served next.
    Returns the minute at which person k is served.
    """
    q = deque(range(1, n + 1))
    minute = 0

    while q:
        minute += 1
        served = q.popleft()

        if served == k:
            return minute

        if q and q[0] % 2 == 1:
            q.append(q.popleft())

    return -1  # k not found (shouldn't happen for valid input)


if __name__ == "__main__":
    print(ticket_counter(4, 3))  # Output: 4