# Detective Aditya's Chase

def dfs(node, graph, visited):
    visited[node] = True
    size = 1

    for neighbor in graph[node]:
        if not visited[neighbor]:
            size += dfs(neighbor, graph, visited)

    return size


n = int(input("Enter number of villages: "))
m = int(input("Enter number of roads: "))

graph = [[] for _ in range(n + 1)]

print("Enter the roads (u v):")
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

visited = [False] * (n + 1)

wells = 0
largest_cluster = 0

for i in range(1, n + 1):
    if not visited[i]:
        cluster_size = dfs(i, graph, visited)
        wells += 1
        largest_cluster = max(largest_cluster, cluster_size)

print("Minimum number of wells needed:", wells)
print("Size of the largest cluster:", largest_cluster)