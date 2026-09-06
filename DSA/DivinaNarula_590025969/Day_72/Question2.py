# Really Special SubTree

def find_parent(parent, node):
    if parent[node] != node:
        parent[node] = find_parent(parent, parent[node])
    return parent[node]


def union(parent, rank, u, v):
    parent_u = find_parent(parent, u)
    parent_v = find_parent(parent, v)

    if parent_u == parent_v:
        return False

    if rank[parent_u] < rank[parent_v]:
        parent[parent_u] = parent_v
    elif rank[parent_u] > rank[parent_v]:
        parent[parent_v] = parent_u
    else:
        parent[parent_v] = parent_u
        rank[parent_u] += 1

    return True


def kruskals(n, edges):
    edges.sort(key=lambda x: x[2])

    parent = [i for i in range(n + 1)]
    rank = [0] * (n + 1)

    total_weight = 0
    edges_used = 0

    for u, v, weight in edges:
        if union(parent, rank, u, v):
            total_weight += weight
            edges_used += 1

            if edges_used == n - 1:
                break

    return total_weight


n, m = map(int, input("Enter number of nodes and edges: ").split())

edges = []

print("Enter edges in the format: node1 node2 weight")
for _ in range(m):
    u, v, weight = map(int, input().split())
    edges.append([u, v, weight])

answer = kruskals(n, edges)
print("Total weight of Minimum Spanning Tree:", answer)