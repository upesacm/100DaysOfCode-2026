matrix = [[1,2,3],
          [4,5,6],
          [7,8,9]]

rows = len(matrix)
cols = len(matrix[0])

transpose = []

for j in range(cols):
    row = []
    for i in range(rows):
        row.append(matrix[i][j])
    transpose.append(row)

print(transpose)