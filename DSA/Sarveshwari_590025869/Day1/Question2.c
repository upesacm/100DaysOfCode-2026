#include <stdio.h>
int main(){
    int n,sum=0;
    printf("Enter number of elements");
    scanf("%d",&n);
     int arr[n];
    printf("Enter elements");
    for (int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    for(int j=0;j<n;j++){
        sum += arr[j];
    }
    printf("Sum of array elemenst is %d",sum);
}