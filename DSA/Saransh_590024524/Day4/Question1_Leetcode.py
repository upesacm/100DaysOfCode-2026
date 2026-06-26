class Solution:
    def transpose(self, matrix):
        ro = len(matrix)
        cl = len(matrix[0])

        tra = [[0]*ro for item in range(cl)]

        for i in range (ro):
            for j in range (cl):
                tra[j][i] = matrix[i][j]

        return tra

