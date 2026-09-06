# Largest Color Value in a Directed Graph

from collections import deque

class Solution(object):
    def largestPathValue(self, colors, edges):
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
                dp[i][ord(colors[i]) - ord('a')] = 1

        visited = 0
        answer = 0

        while q:
            node = q.popleft()
            visited += 1

            answer = max(answer, max(dp[node]))

            for nei in graph[node]:
                for c in range(26):
                    dp[nei][c] = max(
                        dp[nei][c],
                        dp[node][c] + (1 if c == ord(colors[nei]) - ord('a') else 0)
                    )

                indegree[nei] -= 1
                if indegree[nei] == 0:
                    q.append(nei)

        if visited != n:
            return -1

        return answer