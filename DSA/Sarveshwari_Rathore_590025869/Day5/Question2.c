#include <stdio.h>
void sort(int arr[], int n) {
    for(int i = 0; i < n - 1; i++) {
        for(int j = 0; j < n - i - 1; j++) {
            if(arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
int main() {
    int n,m;
    printf("Enter size of arrays: ");
    scanf("%d %d", &n,&m);
    if(n!=m){
        printf("Array size is not equal");
        return 0;
    }
    int arrA[n], arrB[m];
    printf("Enter Array A:\n");
    for(int i = 0; i < n; i++)
        scanf("%d", &arrA[i]);
    printf("Enter Array B:\n");
    for(int i = 0; i < m; i++)
        scanf("%d", &arrB[i]);
    sort(arrA, n);
    sort(arrB, m);
    int equal = 1;
    for(int i = 0; i < n; i++) {
        if(arrA[i] != arrB[i]) {
            equal = 0;
            break;
        }
    }
    if(equal)
        printf("equal");
    else
        printf("not equal");
    return 0;
}