class Solution:
    def waysToBuildRooms(self, prevRoom):
        MOD = 10**9 + 7
        n = len(prevRoom)

        children = [[] for _ in range(n)]

        for i in range(1, n):
            children[prevRoom[i]].append(i)

        fact = [1] * (n + 1)
        inv_fact = [1] * (n + 1)

        for i in range(1, n + 1):
            fact[i] = fact[i - 1] * i % MOD

        inv_fact[n] = pow(fact[n], MOD - 2, MOD)

        for i in range(n, 0, -1):
            inv_fact[i - 1] = inv_fact[i] * i % MOD

        size = [0] * n
        ways = [0] * n

        stack = [(0, 0)]

        while stack:
            u, state = stack.pop()

            if state == 0:
                stack.append((u, 1))

                for v in children[u]:
                    stack.append((v, 0))

            else:
                size[u] = 1
                ways[u] = 1

                for v in children[u]:
                    size[u] += size[v]

                    ways[u] = (
                        ways[u]
                        * ways[v]
                        % MOD
                        * inv_fact[size[v]]
                        % MOD
                    )

                ways[u] = ways[u] * fact[size[u] - 1] % MOD

        return ways[0]