class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        graph = [[] for _ in range(n)]

        
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        visited = [False] * n
        total = 0
        ans = 0

        
        for i in range(n):
            if not visited[i]:
                stack = [i]
                visited[i] = True
                size = 0

                while stack:
                    node = stack.pop()
                    size += 1

                    for nei in graph[node]:
                        if not visited[nei]:
                            visited[nei] = True
                            stack.append(nei)

                
                ans += size * total
                total += size

        return ans