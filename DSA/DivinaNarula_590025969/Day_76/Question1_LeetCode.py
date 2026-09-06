# Count Ways to Build Rooms in an Ant Colony

class Solution(object):
    def waysToBuildRooms(self, prevRoom):
        MOD = 10 ** 9 + 7
        n = len(prevRoom)

        children = [[] for _ in range(n)]
        for i in range(1, n):
            children[prevRoom[i]].append(i)

        fact = [1] * (n + 1)
        for i in range(1, n + 1):
            fact[i] = fact[i - 1] * i % MOD

        invFact = [1] * (n + 1)
        invFact[n] = pow(fact[n], MOD - 2, MOD)
        for i in range(n, 0, -1):
            invFact[i - 1] = invFact[i] * i % MOD

        def dfs(node):
            ways = 1
            total = 0

            for child in children[node]:
                childWays, childSize = dfs(child)
                ways = ways * childWays % MOD
                ways = ways * invFact[childSize] % MOD
                total += childSize

            ways = ways * fact[total] % MOD
            return ways, total + 1

        return dfs(0)[0]