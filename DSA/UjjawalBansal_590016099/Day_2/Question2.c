#include <stdio.h>

int max_num(int* arr, int size) {
    int max= arr[0];
    for(int i= 1; i<size; i++) {
        if(arr[i] >max) max = arr[i];
    }
    return max;
}