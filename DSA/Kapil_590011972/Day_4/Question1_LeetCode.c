#include <stdio.h>
#include <stdlib.h>

typedef struct {
  int *ptr;
  int r_len;
  int c_len;
} matrix;

matrix transpose(matrix);

int main() {
  // taking input
  matrix m1;

  printf("Enter number of rows: ");
  scanf("%d", &m1.r_len);
  printf("Enter number of columns: ");
  scanf("%d", &m1.c_len);

  m1.ptr = (int *)malloc(sizeof(int) * m1.c_len * m1.r_len);

  for (int i = 0; i < m1.r_len; i++) {
    printf("Enter elements for row %d: ", i + 1);
    for (int j = 0; j < m1.c_len; j++) {
      scanf("%d", m1.ptr + i * m1.c_len + j);
    }
  }

  matrix m2 = transpose(m1);

  // printing result
  for (int i = 0; i < m2.r_len; i++) {
    printf("[");
    for (int j = 0; j < m2.c_len; j++) {
      printf(" %d ", (m2.ptr[i * m2.c_len + j]));
    }
    printf("]\n");
  }
}

matrix transpose(matrix m1) {
  matrix m2 = {malloc(sizeof(int) * m1.r_len * m1.c_len), m1.c_len, m1.r_len};

  for (int i = 0; i < m2.r_len; i++) {
    for (int j = 0; j < m2.c_len; j++) {
      m2.ptr[i * m2.c_len + j] = m1.ptr[j * m1.c_len + i];
    }
  }

  return m2;
}
