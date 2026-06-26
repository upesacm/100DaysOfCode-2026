#include<stdio.h>
int main(){
    int n , target ,occurence=0 ;

    printf("enter the size of array:\n");
    scanf("%d",&n);
    printf("Enter the target value:");
    scanf("%d",&target);

    int arr[n];
    printf("Enter a sorted array: ");
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
        if(target==arr[i]){
            occurence++;
        }
    }
     printf("Occurrence = %d", occurence);
    return 0;
}