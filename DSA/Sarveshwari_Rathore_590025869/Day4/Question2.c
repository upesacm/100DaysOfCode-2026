#include <stdio.h>
void rev(int arr[], int start, int end) {
    while(start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
void rotate(int arr[], int n, int k) {
    k = k % n;
    rev(arr, 0, n - 1);
    rev(arr, 0, k - 1);
    rev(arr, k, n - 1);
}
int main(){
    int n,key,temp;
    if(scanf("%d",&n) !=  1 || n<=0){
        printf("Invalid");
    }
    int arr[n];
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    printf("Enter key");
    scanf("%d",&key);
    rotate(arr,n,key);
    for(int i=0;i<n;i++){
        printf("%d,",arr[i]);
    }
}