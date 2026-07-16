/*Next Greater Element in Array
Explanation
Given an array of integers, find the first greater element on the right for every element; if no greater element exists, return -1.*/

#include<stdio.h>
int main(){
    
    int n, i, j;

    printf("Enter the no. of elements: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter the elements: ");
    for(i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    for(i = 0; i < n; i++){
        int temp = -1;

        for(j = i + 1; j < n; j++){
            if (arr[j] > arr[i]) {
                temp = arr[j];
                break;
            }
        }

        printf("%d ", temp);
    }

    return 0;
}