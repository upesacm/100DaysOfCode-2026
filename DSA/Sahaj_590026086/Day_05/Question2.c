#include <stdio.h>
int main(){
    int n1, n2;
    printf("Enter size of first array: ");
    scanf("%d", &n1);
    int arr1[n1];
    printf("Enter elements of first array:\n");
    for(int i=0;i<n1;i++){
        scanf("%d",&arr1[i]);
    }
    printf("Enter size of second array: ");
    scanf("%d", &n2);
    int arr2[n2];
    printf("Enter elements of second array:\n");
    for(int i=0;i<n2;i++){
        scanf("%d", &arr2[i]);
    }
    if(n1!=n2) {
        printf("False\n");
        return 0;
    }
    for(int i=0;i<n1;i++){
        if(arr1[i]!=arr2[i]){
            printf("False\n");
            return 0;
        }
    }

    printf("True\n");
    return 0;
}
