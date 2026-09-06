#include <stdio.h>


int main(){

    int n;
    printf("Enter size: ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter elements: ");
    for(int i=0;i<n;i++)
    scanf("%d",&arr[i]);

    int res=0;
    for(int i=0;i<n;i++){
        res=res^arr[i];
    }
    printf("%d",res);

    return 0;
}
