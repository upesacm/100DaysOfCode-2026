def crab_chaos(C, N, T, M, edges):
    graph = [[] for _ in range(N)]

    for u, v in edges:
        u -= 1
        v -= 1
        graph[u].append(v)
        graph[v].append(u)

    used = [False] * N
    covered = 0
    crabs = 0

    for head in range(N):
        if used[head] or crabs == C:
            continue

        
        used[head] = True
        feet = 0
        current_covered = 1

        for neighbor in graph[head]:
            if not used[neighbor] and feet < T:
                used[neighbor] = True
                feet += 1
                current_covered += 1

        
        if feet > 0:
            covered += current_covered
            crabs += 1
        else:
            used[head] = False

    return covered