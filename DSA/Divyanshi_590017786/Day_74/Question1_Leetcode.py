class Solution:
    def countPairs(self, n, edges):
        graph = [[] for _ in range(n)]

        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        visited = [False] * n

        def dfs(node):
            visited[node] = True
            size = 1

            for neighbor in graph[node]:
                if not visited[neighbor]:
                    size += dfs(neighbor)

            return size

        answer = 0
        remaining = n

        for i in range(n):
            if not visited[i]:
                size = dfs(i)

                # Pairs between this component and
                # all components that haven't been processed
                answer += size * (remaining - size)

                remaining -= size

        return answer