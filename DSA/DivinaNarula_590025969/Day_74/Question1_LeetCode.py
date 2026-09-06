# Count Unreachable Pairs of Nodes in an Undirected Graph

class Solution(object):
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

        remaining = n
        answer = 0

        for i in range(n):
            if not visited[i]:
                component_size = dfs(i)
                remaining -= component_size
                answer += component_size * remaining

        return answer