#include<stdio.h>
int main(){
    int n;
    printf("Enter the size of the array : ");
    scanf("%d",&n);
    int arr[n];
    for(int i=0;i<n;i++){
        printf("Enter the value at %d index : ",i);
        scanf("%d",&arr[i]);
    }
    int value;
    printf("Enter the value you want to find in the array : ");
    scanf("%d",&value);

    int occ =0;
    for(int i=0;i<n;i++){
        if(value==arr[i]){
            occ++;
        }
    }
    if (occ==0) printf("The %d is not present in the array ",value)
    printf("The occurence of %d number is : %d",value,occ);
    return 0;
}