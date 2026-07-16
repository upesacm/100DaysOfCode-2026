#include <stdbool.h>

bool findTriplet(int* arr, int arrSize) {
    for (int i = 0; i < arrSize; i++) {
        for (int j = i + 1; j < arrSize; j++) {
            for (int k = j + 1; k < arrSize; k++) {

                if (arr[i] + arr[j] == arr[k] ||
                    arr[i] + arr[k] == arr[j] ||
                    arr[j] + arr[k] == arr[i]) {
                    
                    return true;
                }
            }
        }
    }

    return false;
}
