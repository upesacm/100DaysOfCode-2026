#include <stdio.h>
#include <stdlib.h>

int compare(const void *a,const void *b){
    return (*(int*) a- *(int*) b);
}
int countmaxsubarr(int arr[],int n,int l,int r){
    int count=0;
    for(int left=0;left<n;left++){
        int right = left;
        while(right<n){
            if( l <= arr[right] && arr[right] <= r ){
            count++;
            printf("%d-%d,",arr[left],arr[right]);
            }
            right++;
        } printf("\n");
    } return count;
}
int main(){
    int n,l,r;
    printf("Enter the size of an array:\n");
    scanf("%d",&n);
    int arr[n];
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    } 
    qsort(arr,n,sizeof(int),compare);
    for(int i=0;i<n;i++){
        printf("%d",arr[i]);
    }
    printf("Enter both the limits:\n");
    scanf("%d %d",&l,&r);
    printf("%d",countmaxsubarr(arr,n,l,r));
}