class Solution(object):
    def transpose(self, matrix):
        if len(matrix) == len(matrix[0]):
            for r in range(len(matrix)):
                for c in range( r + 1, len(matrix[0])):
                    matrix[r][c], matrix[c][r] = matrix[c][r],matrix[r][c]
            return matrix
        else:
            result = [[0] * len(matrix) for _ in range(len(matrix[0])) ]
            for r in range(len(matrix)):
                for c in range(len(matrix[0])):
                    result[c][r] = matrix[r][c]
            return result
