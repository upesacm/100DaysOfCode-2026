def crab_chaos(C, N, T, M, edges):
    graph = [[] for _ in range(N + 1)]

    for u, v in edges:
        graph[u].append(v)
        graph[v].append(u)

    used = [False] * (N + 1)
    answer = 0

    for head in range(1, N + 1):
        if used[head]:
            continue

        feet = []

        for neighbour in graph[head]:
            if not used[neighbour]:
                feet.append(neighbour)

        # A crab needs at least one foot
        if feet:
            used[head] = True
            answer += 1

            count = 0
            for foot in feet:
                if count == T:
                    break

                if not used[foot]:
                    used[foot] = True
                    answer += 1
                    count += 1

    return answer


C = 1
N = 4
T = 1
M = 2
edges = [[1, 2], [3, 4]]

print(crab_chaos(C, N, T, M, edges))