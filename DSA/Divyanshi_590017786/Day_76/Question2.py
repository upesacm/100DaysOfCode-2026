def has_euler_trail(n, edges, k):
    # Build the graph as a list of edges
    current_edges = edges[:]

    for _ in range(k):
        m = len(current_edges)

        # Two edges become adjacent in the line graph
        # if they share a vertex.
        new_edges = []

        for i in range(m):
            for j in range(i + 1, m):
                a, b = current_edges[i]
                c, d = current_edges[j]

                if a == c or a == d or b == c or b == d:
                    new_edges.append((i, j))

        current_edges = new_edges
        n = m

    # Build degree array
    degree = [0] * n

    for u, v in current_edges:
        degree[u] += 1
        degree[v] += 1

    # An undirected graph has an Euler trail iff
    # it has exactly 0 or 2 vertices of odd degree.
    odd = 0

    for d in degree:
        if d % 2 == 1:
            odd += 1

    return odd == 0 or odd == 2