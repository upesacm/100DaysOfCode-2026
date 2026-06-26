#include<stdio.h>
int main(){
    int n;
    printf("Enter the size of the array : ");
    scanf("%d",&n);
    int arr[n];
    for(int i=0;i<n;i++){
        printf("Enter the element at %d index : ",i);
        scanf("%d",&arr[i]);
    }
    int maxelement = arr[0];
    for(int i=1;i<n;i++){
        if(maxelement<arr[i]){
            maxelement = arr[i];
        }
    }
    printf("The maximum element is : %d",maxelement);
    return 0;
}