#include <stdio.h>
int main(){
    int n, val;
    scanf("%d",&n);
    printf("Enter elements in array: ");
    int arr[n];
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }int k=0;
    printf("Enter number to be removed: ");
    scanf("%d",&val);
    for(int i=0;i<n;i++){
        if(arr[i] != val)
          {arr[k]=arr[i];
          k++;
    }}
    printf("Number of elements remaining : %d",k);
}