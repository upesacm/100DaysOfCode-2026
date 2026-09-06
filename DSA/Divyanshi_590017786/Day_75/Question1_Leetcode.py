from collections import deque

class Solution:
    def largestPathValue(self, colors, edges):
        n = len(colors)

        graph = [[] for _ in range(n)]
        indegree = [0] * n

        for u, v in edges:
            graph[u].append(v)
            indegree[v] += 1

        # dp[node][color] = maximum count of that color
        # on any path ending at this node
        dp = [[0] * 26 for _ in range(n)]

        queue = deque()

        for i in range(n):
            if indegree[i] == 0:
                queue.append(i)

        processed = 0
        answer = 0

        while queue:
            node = queue.popleft()
            processed += 1

            color = ord(colors[node]) - ord('a')
            dp[node][color] += 1

            answer = max(answer, dp[node][color])

            for neighbor in graph[node]:
                for c in range(26):
                    dp[neighbor][c] = max(
                        dp[neighbor][c],
                        dp[node][c]
                    )

                indegree[neighbor] -= 1

                if indegree[neighbor] == 0:
                    queue.append(neighbor)

        # If not all nodes were processed, graph has a cycle
        if processed != n:
            return -1

        return answer