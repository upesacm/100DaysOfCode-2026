class Solution(object):
    def transpose(self, matrix):
        rows = len(matrix)
        cols = len(matrix[0])
        ar = [[0] * rows for _ in range(cols)]
        for i in range(rows):
            for j in range(cols):
                ar[j][i] = matrix[i][j]
        return ar
#Leetcode solution ends here...below is just a test case to check my code.
matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
obj = Solution()
result = obj.transpose(matrix)
print(result)