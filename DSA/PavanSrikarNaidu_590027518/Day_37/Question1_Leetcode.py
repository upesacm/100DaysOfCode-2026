from collections import deque

class RecentCounter:
    def __init__(self):
        self.q = deque()

    def ping(self, t: int) -> int:
        self.q.append(t)
        while self.q[0] < t - 3000:
            self.q.popleft()
        return len(self.q)



if __name__ == "__main__":
    recentCounter = RecentCounter()
    print(recentCounter.ping(1))     
    print(recentCounter.ping(100))   
    print(recentCounter.ping(3001))  
    print(recentCounter.ping(3002))  