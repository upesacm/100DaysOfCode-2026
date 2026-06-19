#include <stdio.h>

void reverse(int* nums, int left, int right) {
    while (left < right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
    }
}

void rotate(int* nums, int numsSize, int k) {
    k = k % numsSize;  
    if (k == 0) return;

    reverse(nums, 0, numsSize - 1);  
    reverse(nums, 0, k - 1);         
    reverse(nums, k, numsSize - 1);  
}

void printArray(int* nums, int size) {
    
    for (int i = 0; i < size; i++) {
        printf("%d", nums[i]);
        if (i < size - 1) printf(", ");
    }
}

int main() {
    int a[] = {1, 2, 3, 4, 5, 6, 7};
    rotate(a, 7, 3);
    printArray(a, 7);  
    int b[] = {-1, -100, 3, 99};
    rotate(b, 4, 2);
    printArray(b, 4);  

    int c[] = {1, 2, 3};
    rotate(c, 3, 6);   
    printArray(c, 3);  
    return 0;
}
