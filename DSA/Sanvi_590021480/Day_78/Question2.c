#include <stdio.h>


int main(){

    int n;
    printf("Enter size: ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter elements: ");
    for(int i=0;i<n;i++)
    scanf("%d",&arr[i]);

    int max=0,res;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            res=arr[i]^arr[j];
        }
        if(res>max)
        max=res;
    }
    printf("%d",max);

    return 0;
}
