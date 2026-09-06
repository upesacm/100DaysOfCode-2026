def minCost(n, roads):
    graph = [[] for _ in range(n + 1)]

    for u, v, cost in roads:
        graph[u].append((v, cost, 0))
        graph[v].append((u, cost, 1))

    def dfs(start):
        visited = [False] * (n + 1)
        stack = [start]
        cost = 0

        while stack:
            u = stack.pop()

            if visited[u]:
                continue

            visited[u] = True

            for v, c, reverse in graph[u]:
                if not visited[v]:
                    cost += c if reverse else 0
                    stack.append(v)

        return cost

    return min(dfs(1), dfs(1))