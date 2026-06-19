#include <stdio.h>

void reverse(int *, int, int);

int main() {
  int len, k;
  printf("Enter the length of array: ");
  scanf("%d", &len);
  printf("Enter value of k: ");
  scanf("%d", &k);

  int arr[len];
  printf("Enter the elments of array: ");
  for (int i = 0; i < len; i++)
    scanf("%d", &arr[i]);

  reverse(arr, 0, len - 1);
  reverse(arr, 0, k - 1);
  reverse(arr, k, len - 1);
  for (int i = 0; i < len; i++)
    printf("%d ", arr[i]);
}

void reverse(int *arr, int start, int stop) {
  int temp;

  for (int i = start; i < (start + stop + 1) / 2; i++) {
    temp = arr[start + stop - i];
    arr[start + stop - i] = arr[i];
    arr[i] = temp;
  }
}
