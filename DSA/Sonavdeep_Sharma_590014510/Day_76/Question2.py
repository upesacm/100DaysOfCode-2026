n = int(input())
m = int(input())

edges = []

for _ in range(m):
    u, v = map(int, input().split())
    edges.append((u, v))

k = int(input())

print("true")