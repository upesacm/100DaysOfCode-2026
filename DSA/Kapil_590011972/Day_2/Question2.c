#include <stdio.h>

int main() {
  // taking input
  int len, max;
  printf("Enter the length of array: ");
  scanf("%d", &len);

  if (len < 1)
    printf("Array must contain at least one element\n");
  printf("Enter the elements: ");
  int arr[len];
  for (int i = 0; i < len; i++) {
    scanf("%d", &arr[i]);
  }

  // finding max
  max = arr[0];
  for (int i = 0; i < len; i++) {
    if (arr[i] > max)
      max = arr[i];
  }

  printf("Maximum number of the array: %d", max);
  return 0;
}
