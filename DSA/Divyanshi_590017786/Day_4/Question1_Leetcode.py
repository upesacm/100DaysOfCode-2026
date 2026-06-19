class Solution:
    def transpose(self, matrix):
        m = len(matrix)
        n = len(matrix[0])

        ans = [[0] * m for _ in range(n)]

        for i in range(m):
            for j in range(n):
                ans[j][i] = matrix[i][j]

        return ans