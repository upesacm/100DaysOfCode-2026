#include <stdio.h>

int main(){

    int n;
    printf("Enter the size of array: ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter array elements: ");
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int target,count=0;
    printf("Enter target value: ");
    scanf("%d",&target);
    for(int i=0;i<n;i++){
        if(arr[i]==target)
        count++;
    }
    printf("%d",count);

    return 0;
}
