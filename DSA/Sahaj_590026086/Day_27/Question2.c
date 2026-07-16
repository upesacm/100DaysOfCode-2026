#include <stdio.h>
int main(){
    int n;
    printf("Enter the size of the array:");
    scanf("%d", &n);
    int arr[n];
    for (int i=0;i<n;i++){ 
        printf("Enter the element:");
        scanf("%d",&arr[i]);
    }
    int l, r;
    printf("enter the l and r:");
    scanf("%d %d", &l, &r);
    int count=0;
    int prev=-1, last=-1;
    for (int i=0;i<n;i++){
        if (arr[i] > r)
            prev=i;
        if (arr[i]>=l&&arr[i]<=r)
            last=i;
        count+=(last-prev);
    }
    printf("%d\n", count);
    return 0;
}
