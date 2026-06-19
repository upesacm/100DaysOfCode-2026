class Solution:
    def transpose(self, matrix):
        rows = len(matrix)
        cols = len(matrix[0])

        result = [[0] * rows for _ in range(cols)]

        for i in range(rows):
            for j in range(cols):
                result[j][i] = matrix[i][j]

        return result


# Test the code
if __name__ == "__main__":
    sol = Solution()

    matrix1 = [[1, 2, 3],
               [4, 5, 6],
               [7, 8, 9]]

    print("Original Matrix:")
    for row in matrix1:
        print(row)

    print("\nTransposed Matrix:")
    result = sol.transpose(matrix1)
    for row in result:
        print(row)