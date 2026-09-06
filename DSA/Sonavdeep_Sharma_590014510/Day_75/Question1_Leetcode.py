class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        from collections import deque


        n = len(colors)

        graph = [[] for _ in range(n)]
        indegree = [0] * n

        for u, v in edges:
            graph[u].append(v)
            indegree[v] += 1

        dp = [[0] * 26 for _ in range(n)]
        q = deque()

        for i in range(n):
            if indegree[i] == 0:
                q.append(i)

        ans = 0
        count = 0

        while q:
            u = q.popleft()
            count += 1

            c = ord(colors[u]) - ord('a')
            dp[u][c] += 1

            ans = max(ans, max(dp[u]))

            for v in graph[u]:
                for i in range(26):
                    dp[v][i] = max(dp[v][i], dp[u][i])

                indegree[v] -= 1

                if indegree[v] == 0:
                    q.append(v)

        if count != n:
            return -1

        return ans