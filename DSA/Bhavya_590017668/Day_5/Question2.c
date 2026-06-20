#include<stdio.h>
#include<stdbool.h>
int main(){
    bool flag= true;
    int n;
    printf("Enter the size of the array : ");
    scanf("%d",&n);
    int arr[n];
    for(int i=0;i<n;i++){
        printf("Enter the element at %d index : ",i);
        scanf("%d",&arr[i]);
    }
    int m ;
    printf("Enter the size of the second array : ");
    scanf("%d",&m);
    int brr[m];
    for(int i=0;i<m;i++){
        printf("Enter the element at %d index : ",i);
        scanf("%d",&brr[i]);
    }

    if(m==n){
        for(int i=0;i<n;i++){
            if(arr[i]!=brr[i]){
                printf("Two arrays are not same");
                flag = false;
                break;
            }
        }
        if(flag==true){
            printf("Two array are same");
        }
    }
    else{
        printf("Array size is not same");
    }
    return 0;
}