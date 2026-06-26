#include <stdio.h>

int element_index(int *, int, int);
int count_element(int *, int, int);

int main() {
  // taking input
  int len, target;

  printf("Enter the length of array: ");
  scanf("%d", &len);

  // enter arr elements as "1 2 3 44 45"
  int arr[len];
  printf("Enter the elements: ");
  for (int i = 0; i < len; i++) {
    scanf("%d", &arr[i]);
  }

  printf("Enter target: ");
  scanf("%d", &target);

  printf("Occurrences of target: %d",
         count_element(arr, len, element_index(arr, len, target)));
  return 0;
}

int element_index(int *arr, int len, int target) {
  int low = 0;
  int high = len - 1;

  while (low <= high) {
    int mid = low + (high - low) / 2;

    if (arr[mid] == target) {
      return mid;
    } else if (target > arr[mid]) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }

  return -1;
}

int count_element(int *arr, int len, int index) {
  if (index == -1)
    return 0;

  int low = index, high = index, target = arr[index];

  while (low > 0 && arr[low - 1] == target)
    low--;
  while (high < len - 1 && arr[high + 1] == target)
    high++;

  return high - low + 1;
}
