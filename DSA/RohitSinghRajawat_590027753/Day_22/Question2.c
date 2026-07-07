#include <stdio.h>
int main(){
    int n;
    scanf("%d",&n);
    int arr[n];
    printf("Enter the Card Numbers:\n");
    for(int i = 0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int left=0;
    int p1=0,p2=0;
    int right=n-1;
    int t=1;
    while(left <= right){
        if(t%2 != 0){
            if(arr[left]>arr[right]){
                p1 += arr[left++];
            }else{
                p1 += arr[right--];
            }
        }
        else {
            if(arr[left]>arr[right]){
                p2+=arr[left++];
            }else{
                p2 += arr[right--];
            }
        } t++;
    } 
    printf("%d %d",p1,p2);
}