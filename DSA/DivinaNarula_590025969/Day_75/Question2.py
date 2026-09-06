# Minimum Cost to Make a Ring Strongly Connected

def minimum_cost_to_make_ring_strongly_connected(n, roads):
    clockwise = [0] * n
    counter = [0] * n

    for u, v, cost in roads:
        u -= 1
        v -= 1

        if (u + 1) % n == v:
            counter[u] = cost
        else:
            clockwise[v] = cost

    cost_clockwise = sum(clockwise)
    cost_counter = sum(counter)

    return min(cost_clockwise, cost_counter)


n = int(input("Enter number of cities: "))
m = int(input("Enter number of roads: "))

roads = []

print("Enter each road as: from to cost")
for _ in range(m):
    u, v, c = map(int, input().split())
    roads.append([u, v, c])

print("Minimum cost:", minimum_cost_to_make_ring_strongly_connected(n, roads))