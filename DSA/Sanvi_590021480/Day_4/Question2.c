#include <stdio.h>

int main(){

    int n;
    printf("Enter the size of array: ");
    scanf("%d",&n);
    int nums[n];
    printf("Enter the elements: ");
    for(int i=0;i<n;i++){
        scanf("%d",&nums[i]);
    }
    int k;
    printf("Enter the number of steps: ");
    scanf("%d",&k);

    k=k%n;
    int temp[n];
    int index=0;
    for(int i=n-k;i<n;i++){
        temp[index++]=nums[i];
    }
    for(int i=0;i<n-k;i++){
        temp[index++]=nums[i];
    }
    printf("The rotated array: ");
    for(int i=0;i<n;i++){
        nums[i]=temp[i];
        printf("%d ",nums[i]);
    }
  
    return 0;
}
