#include <stdio.h>
 int main(){
    int arr[]={0,1,2,4};
    int n=sizeof(arr)/sizeof(arr[0]);
    int sum= (n*(n+1))/2;
    int add=0;
    for(int i=0;i<n;i++){
        add+=arr[i];
    }
    int m= sum - add;
    printf("The missing number is: %d",m);
    return 0;
 }