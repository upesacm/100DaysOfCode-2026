class Solution:
    def waysToBuildRooms(self, prevRoom: List[int]) -> int:
        MOD = 10**9 + 7
        n = len(prevRoom)

        # Build tree
        children = [[] for _ in range(n)]

        for i in range(1, n):
            children[prevRoom[i]].append(i)

        # Factorials
        fact = [1] * (n + 1)

        for i in range(1, n + 1):
            fact[i] = fact[i - 1] * i % MOD

        # Inverse factorials
        invFact = [1] * (n + 1)
        invFact[n] = pow(fact[n], MOD - 2, MOD)

        for i in range(n, 0, -1):
            invFact[i - 1] = invFact[i] * i % MOD

        def comb(n, r):
            return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD

        def dfs(u):
            size = 1
            ways = 1
            placed = 0

            for v in children[u]:
                subSize, subWays = dfs(v)

                # Ways inside the subtree
                ways = ways * subWays % MOD

                # Interleave this subtree with previously placed nodes
                ways = ways * comb(placed + subSize, subSize) % MOD

                placed += subSize
                size += subSize

            return size, ways

        return dfs(0)[1]
