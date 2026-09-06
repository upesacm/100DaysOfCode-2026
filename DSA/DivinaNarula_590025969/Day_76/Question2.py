# Does the k-th Line Graph Still Have an Euler Trail?

from collections import defaultdict


def has_euler_trail(vertices, edges):
    if not edges:
        return True

    graph = defaultdict(list)
    degree = defaultdict(int)

    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)
        degree[u] += 1
        degree[v] += 1

    start = next(iter(degree))
    visited = set()
    stack = [start]

    while stack:
        node = stack.pop()
        if node in visited:
            continue
        visited.add(node)
        for nei in graph[node]:
            if nei not in visited:
                stack.append(nei)

    for node in degree:
        if node not in visited:
            return False

    odd = sum(1 for node in degree if degree[node] % 2 == 1)
    return odd == 0 or odd == 2


def line_graph(edges):
    m = len(edges)
    new_edges = []

    for i in range(m):
        u1, v1 = edges[i]
        for j in range(i + 1, m):
            u2, v2 = edges[j]

            if u1 == u2 or u1 == v2 or v1 == u2 or v1 == v2:
                new_edges.append((i, j))

    return m, new_edges


n = int(input("Enter number of vertices: "))
m = int(input("Enter number of edges: "))

edges = []
print("Enter the edges:")
for _ in range(m):
    u, v = map(int, input().split())
    edges.append((u, v))

k = int(input("Enter k: "))

vertices = n

for _ in range(k):
    vertices, edges = line_graph(edges)

if has_euler_trail(vertices, edges):
    print("true")
else:
    print("false")