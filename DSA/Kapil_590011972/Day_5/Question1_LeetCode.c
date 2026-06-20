#include <stdio.h>

int canJump(int nums[], int len) {
  int farthest = 0;

  for (int i = 0; i < len; i++) {
    if (i > farthest)
      return 0;

    if (i + nums[i] > farthest)
      farthest = i + nums[i];

    if (farthest >= len - 1)
      return 1;
  }

  return 1;
}

int main() {
  int len;
  printf("Enter length of array: ");
  scanf("%d", &len);

  int arr[len];
  printf("Enter the elements: ");
  for (int i = 0; i < len; i++) {
    scanf("%d", arr + i);
  }

  printf("%s\n", canJump(arr, len) ? "true" : "false");

  return 0;
}
