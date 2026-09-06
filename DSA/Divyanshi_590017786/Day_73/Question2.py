def solve(n, edges):
    graph = [[] for _ in range(n + 1)]

    # Build graph
    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    visited = [False] * (n + 1)
    components = 0
    largest = 0

    def dfs(node):
        visited[node] = True
        size = 1

        for neighbour in graph[node]:
            if not visited[neighbour]:
                size += dfs(neighbour)

        return size

    # Find connected clusters
    for i in range(1, n + 1):
        if not visited[i]:
            components += 1
            size = dfs(i)
            largest = max(largest, size)

    return components, largest


N = 4
M = 3
edges = [(1, 2), (2, 3), (1, 4)]

print(*solve(N, edges))