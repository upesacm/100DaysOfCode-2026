def min_cost(n, roads):
    graph = [[] for _ in range(n + 1)]

    for u, v, cost in roads:
        graph[u].append((v, cost, 0))
        graph[v].append((u, cost, 1))

    # Try each city as the starting point.
    # cost 0 = keep direction
    # cost 1 = reverse direction
    def dfs(node, parent):
        total = 0

        for nxt, cost, reverse in graph[node]:
            if nxt != parent:
                total += reverse * cost
                total += dfs(nxt, node)

        return total

    # For a ring, calculate the cost for one orientation.
    return min(dfs(1, -1), dfs(1, -1))