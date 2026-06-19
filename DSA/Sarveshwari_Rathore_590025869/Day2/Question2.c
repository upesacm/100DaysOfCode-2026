#include <stdio.h>
int main(){
    int n;
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Invalid input");
        return 0;
    }
    int arr[n];
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int l=arr[0];
    for(int j=1;j<n;j++){
        if(arr[j]>l){
            l=arr[j];
        }
    }
    printf("Largest Number is %d",l);
}