#include <stdio.h>

int find_first(int* arr, int n, int target) {
    int l=0, r = n-1;

    while (l <=r) {
        int mid = l+(r-l)/2;

        if(arr[mid] ==target){
            if(mid ==0 ||arr[mid-1] !=target) {
                return mid;
            }
            else{
                r = mid-1;
            }
        }
        else if(arr[mid] < target){
            l = mid+1;
        }
        else {
            r = mid-1;
        }
    }
    return -1;
}

int find_last(int* arr, int n, int target) {
    int l= 0, r = n-1;

    while(l <=r) {
        int mid = l+(r-l)/2;

        if (arr[mid] ==target){
            if (mid==n-1 || arr[mid+1]!=target) {
                return mid;
            }
            else{
                l = mid+1;
            }
        }
        else if(arr[mid] < target){
            l=mid + 1;
        }
        else{
            r = mid-1;
        }
    }
    return -1;
}

int main(){
    int n, target;
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter the elements of the array: ");
    for(int i=0; i<n; i++) {
        scanf("%d", &arr[i]);}

    printf("Enter the target element: ");
    scanf("%d", &target);

    int f = find_first(arr, n, target);
    int l = find_last(arr, n, target);

    if (f== -1) {
        printf("No. of occurrences of %d: 0\n", target);
    } else {
        printf("No. of occurrences of %d: %d\n", target, l - f + 1);
    }
    return 0;
}