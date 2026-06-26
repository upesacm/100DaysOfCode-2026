#include <stdio.h>
int main(){
    int n1, n2;
    printf("Enter size of first array: ");
    scanf("%d", &n1);
    int arr1[n1];
    printf("Enter elements of first sorted array:\n");
    for(int i=0;i<n1;i++){
      printf("Enter the element:");
      scanf("%d", &arr1[i]);
    }
    printf("Enter size of second array: ");
    scanf("%d", &n2);
    int arr2[n2];
    printf("Enter elements of second sorted array:\n");
    for(int i=0;i<n2;i++){
      printf("Enter the element:");
      scanf("%d", &arr2[i]);
    }
    int i=0,j=0;
    printf("Union: ");
    while(i<n1&&j<n2){
        if(arr1[i]<arr2[j]){
            if(i==0||arr1[i]!=arr1[i-1])
                printf("%d ", arr1[i]);
            i++;
        }
        else if(arr1[i]>arr2[j]){
            if(j==0||arr2[j]!=arr2[j-1])
                printf("%d ", arr2[j]);
            j++;
        }
        else{
            if(i==0||arr1[i]!=arr1[i-1])
                printf("%d ", arr1[i]);
            i++;
            j++;
        }
    }
    while(i<n1){
        if(i==0||arr1[i]!=arr1[i-1])
            printf("%d ", arr1[i]);
        i++;
    }
    while(j<n2){
        if(j==0||arr2[j]!=arr2[j-1])
            printf("%d ", arr2[j]);
        j++;
    }
    return 0;
}
