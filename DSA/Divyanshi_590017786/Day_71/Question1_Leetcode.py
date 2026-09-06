class Solution:
    def findJudge(self, n, trust):
        degree = [0] * (n + 1)

        for a, b in trust:
            degree[a] -= 1   # a trusts someone
            degree[b] += 1   # b is trusted by someone

        for person in range(1, n + 1):
            if degree[person] == n - 1:
                return person

        return -1