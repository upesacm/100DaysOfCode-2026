#include <stdio.h>
void unionarray(int arr1[], int n, int arr2[], int m) {
    int i=0,j=0;
    while(i<n && j<m){
        if (i > 0 && arr1[i] == arr1[i-1]) {
            i++;
            continue;
        }
        if (j>0 && arr2[j] == arr2[j-1]) {
            j++;
            continue;
        }
        if (arr1[i] < arr2[j]) {
            printf("%d ",arr1[i]);
            i++;
        }
        else if (arr1[i] > arr2[j]) {
            printf("%d ",arr2[j]);
            j++;
        }
        else {
            printf("%d ",arr1[i]);
            i++;
            j++;
        }
    }
    while (i < n) {
        if (i == 0 || arr1[i] != arr1[i-1])
            printf("%d ",arr1[i]);
        i++;
    }
    while (j < m) {
        if (j == 0 || arr2[j] != arr2[j - 1])
            printf("%d ",arr2[j]);
        j++;
    } printf("\n");
}
int main() {
    int arr1[] = {1,2,3,4};
    int arr2[] = {3,4,5};
    unionarray(arr1, 4, arr2, 3);
    int arr3[] = {6,7};
    int arr4[] = {6,7};
    unionarray(arr3, 2, arr4, 2);
    return 0;
}