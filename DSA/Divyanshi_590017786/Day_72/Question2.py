class DSU:
    def __init__(self, n):
        self.parent = list(range(n + 1))
        self.rank = [0] * (n + 1)

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, a, b):
        root_a = self.find(a)
        root_b = self.find(b)

        if root_a == root_b:
            return False

        if self.rank[root_a] < self.rank[root_b]:
            root_a, root_b = root_b, root_a

        self.parent[root_b] = root_a

        if self.rank[root_a] == self.rank[root_b]:
            self.rank[root_a] += 1

        return True


def kruskal(n, edges):
    # Sort edges by weight
    edges.sort(key=lambda x: x[2])

    dsu = DSU(n)
    total = 0
    count = 0

    for u, v, weight in edges:
        if dsu.union(u, v):
            total += weight
            count += 1

            # MST has exactly n-1 edges
            if count == n - 1:
                break

    return total


n = 4
edges = [
    [1, 2, 5],
    [1, 3, 3],
    [4, 1, 6],
    [2, 4, 7],
    [3, 2, 4],
    [3, 4, 5]
]

print(kruskal(n, edges))