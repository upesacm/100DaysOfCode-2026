class Solution:
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