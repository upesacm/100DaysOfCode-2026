#include <stdio.h>

// Function to find the first (leftmost) occurrence of the target using Binary Search
int findFirstOccurrence(int arr[], int n, int target) {
    int low = 0, high = n - 1;
    int first = -1;
    
    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (arr[mid] == target) {
            first = mid;
            high = mid - 1; // Keep looking left for the first occurrence
        } else if (arr[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return first;
}

// Function to find the last (rightmost) occurrence of the target using Binary Search
int findLastOccurrence(int arr[], int n, int target) {
    int low = 0, high = n - 1;
    int last = -1;
    
    while (low <= high) {
        int mid = low + (high - low) / 2;
        
        if (arr[mid] == target) {
            last = mid;
            low = mid + 1; // Keep looking right for the last occurrence
        } else if (arr[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return last;
}

// Function to calculate total occurrences
int countOccurrences(int arr[], int n, int target) {
    int first = findFirstOccurrence(arr, n, target);
    if (first == -1) {
        return 0; // Element is not present
    }
    int last = findLastOccurrence(arr, n, target);
    return last - first + 1;
}

int main() {
    int size;

    //Get the size of the array
    printf("Enter size of array: ");
    scanf("%d", &size);

    int array[size];

    //Get the array elements
    printf("Enter %d numbers for the array: ", size);
    for (int i = 0; i < size; i++) {
        scanf("%d", &array[i]);
    }

    //Get the target element to search for
    int target;
    printf("Enter target element: ");
    scanf("%d", &target);

    //Print result
    printf("Output: %d\n", countOccurrences(array, size, target)); 

    return 0;
}