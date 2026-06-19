//Given an integer array, determine the largest element present in the array
#include <stdio.h>
int largest(int arr[],int n){
    int max=arr[0];
    for(int i=0;i<n;i++){
        if(arr[i]>max){
            max=arr[i];
        }
    }
    return max;
}
int main(){
    int arr[]={3,8,2,9,1};
    int n=sizeof(arr)/sizeof(arr[0]);
    int max=largest(arr,n);
    printf("Largest element in the array: %d\n",max);   
    return 0;
}