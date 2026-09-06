# Crab Chaos

from collections import deque


class Edge:
    def __init__(self, to, rev, cap):
        self.to = to
        self.rev = rev
        self.cap = cap


class Dinic:
    def __init__(self, n):
        self.n = n
        self.graph = [[] for _ in range(n)]

    def add_edge(self, u, v, cap):
        self.graph[u].append(Edge(v, len(self.graph[v]), cap))
        self.graph[v].append(Edge(u, len(self.graph[u]) - 1, 0))

    def bfs(self, source, sink):
        self.level = [-1] * self.n
        queue = deque([source])
        self.level[source] = 0

        while queue:
            node = queue.popleft()

            for edge in self.graph[node]:
                if edge.cap > 0 and self.level[edge.to] == -1:
                    self.level[edge.to] = self.level[node] + 1
                    queue.append(edge.to)

        return self.level[sink] != -1

    def dfs(self, node, sink, flow):
        if node == sink:
            return flow

        while self.ptr[node] < len(self.graph[node]):
            edge = self.graph[node][self.ptr[node]]

            if edge.cap > 0 and self.level[edge.to] == self.level[node] + 1:
                pushed = self.dfs(edge.to, sink, min(flow, edge.cap))

                if pushed:
                    edge.cap -= pushed
                    self.graph[edge.to][edge.rev].cap += pushed
                    return pushed

            self.ptr[node] += 1

        return 0

    def max_flow(self, source, sink):
        total = 0

        while self.bfs(source, sink):
            self.ptr = [0] * self.n

            while True:
                flow = self.dfs(source, sink, float("inf"))

                if flow == 0:
                    break

                total += flow

        return total


def crab_graph(n, t, edges):
    source = 0
    left = 1
    right = left + n
    sink = right + n

    dinic = Dinic(sink + 1)

    for i in range(n):
        dinic.add_edge(source, left + i, t)
        dinic.add_edge(right + i, sink, 1)

    for u, v in edges:
        u -= 1
        v -= 1
        dinic.add_edge(left + u, right + v, 1)
        dinic.add_edge(left + v, right + u, 1)

    return dinic.max_flow(source, sink)


def main():
    while True:
        try:
            c = int(input("Enter the number of test cases: "))
            break
        except ValueError:
            print("Please enter a valid integer.")

    for case in range(1, c + 1):
        print("\nTest Case", case)

        while True:
            try:
                n = int(input("Enter the number of vertices: "))
                break
            except ValueError:
                print("Please enter a valid integer.")

        while True:
            try:
                t = int(input("Enter the maximum feet per crab (T): "))
                break
            except ValueError:
                print("Please enter a valid integer.")

        while True:
            try:
                m = int(input("Enter the number of edges: "))
                break
            except ValueError:
                print("Please enter a valid integer.")

        edges = []

        print("Enter each edge (u v):")
        for _ in range(m):
            while True:
                try:
                    u, v = map(int, input().split())
                    edges.append((u, v))
                    break
                except ValueError:
                    print("Please enter two integers separated by a space.")

        answer = crab_graph(n, t, edges)

        print("Maximum number of vertices covered:", answer)


if __name__ == "__main__":
    main()