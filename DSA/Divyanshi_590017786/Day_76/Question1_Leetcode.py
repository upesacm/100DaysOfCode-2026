class Solution:
    def waysToBuildRooms(self, prevRoom):
        MOD = 10**9 + 7
        n = len(prevRoom)

        children = [[] for _ in range(n)]

        for i in range(1, n):
            children[prevRoom[i]].append(i)

        # factorials and inverse factorials
        fact = [1] * (n + 1)
        inv_fact = [1] * (n + 1)

        for i in range(1, n + 1):
            fact[i] = fact[i - 1] * i % MOD

        inv_fact[n] = pow(fact[n], MOD - 2, MOD)

        for i in range(n - 1, -1, -1):
            inv_fact[i] = inv_fact[i + 1] * (i + 1) % MOD

        def combination(a, b):
            return (
                fact[a]
                * inv_fact[b]
                % MOD
                * inv_fact[a - b]
                % MOD
            )

        def dfs(node):
            # size = number of rooms in this subtree
            size = 1
            ways = 1

            for child in children[node]:
                child_size, child_ways = dfs(child)

                # Choose positions for child's subtree
                ways = ways * combination(
                    size + child_size - 1,
                    child_size
                ) % MOD

                ways = ways * child_ways % MOD
                size += child_size

            return size, ways

        return dfs(0)[1]