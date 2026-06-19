#include <stdio.h>

int findLargestElement(int arr[], int size) {
    // Check if the array is empty
    if (size <= 0) {
        return -1; 
    }

    // Initialize max_val with the first element
    int max_val = arr[0];

    // Loop through the rest of the elements
    for (int i = 1; i < size; i++) {
        if (arr[i] > max_val) {
            max_val = arr[i];
        }
    }
return max_val;
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

    //Print result
    printf("Output: %d\n", findLargestElement(array, size)); 

return 0;
}