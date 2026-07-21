from collections import deque

class RecentCounter:

    def __init__(self):
        self.q = deque()

    def ping(self, t: int) -> int:
        # Add the new request time
        self.q.append(t)

        # Remove requests older than t - 3000
        while self.q[0] < t - 3000:
            self.q.popleft()

        # Remaining requests are within [t-3000, t]
        return len(self.q)