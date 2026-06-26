class Solution(object):
    def transpose(self, matrix):
        rows = len(matrix)
        cols = len(matrix[0])
        arr = [[0] * rows for _ in range(cols)]
        for i in range(cols):
            for j in range(rows):
                arr[i][j] = matrix[j][i]

        return arr
      