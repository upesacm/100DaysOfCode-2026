#include <stdio.h>
#include <stdlib.h>

typedef struct {
  int *array;
  int len;
  int offset;
} arr;

arr adder(arr);

int main() {
  // takjing input
  arr a1;
  printf("Enter the length of array: ");
  scanf("%d", &a1.len);

  a1.array = malloc(a1.len * sizeof(int));
  printf("Enter elements: ");
  for (int i = 0; i < a1.len; i++) {
    scanf("%d", &a1.array[i]);
  }

  arr a2 = adder(a1);
  printf("New array: ");
  for (int i = a2.offset; i < a2.len; i++) {
    printf("%d ", a2.array[i]);
  }
  free((void *)a1.array);
  free((void *)(a2.array));
}

arr adder(arr a1) {
  arr a2 = (arr){malloc(sizeof(int) * (a1.len + 1)), a1.len + 1, 0};

  int carry = 1;

  for (int i = a1.len - 1; i >= 0; i--) {
    int sum = a1.array[i] + carry;

    a2.array[i + 1] = sum % 10;
    carry = sum / 10;
  }

  a2.array[0] = carry;

  if (!carry) {
    a2.offset = 1;
  }

  return a2;
}
