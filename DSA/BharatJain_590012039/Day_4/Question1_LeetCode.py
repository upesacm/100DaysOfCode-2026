class Solution(object):
    def transpose(self, matrix):
        rows = len(matrix)
        cols = len(matrix[0])

        result = []

        for j in range(cols):
            row = []
            for i in range(rows):
                row.append(matrix[i][j])
            result.append(row)

        return result


matrix = [
    [1, 2, 3],
    [4, 5, 6]
]

sol = Solution()
print(sol.transpose(matrix))