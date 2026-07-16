#include <stdio.h>

int main() {
    
    int n;
    printf("Enter the size of array: ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter array elements: ");
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    int top=-1;
    int stack[n];
    int ans[n];
    for(int i=n-1;i>=0;i--){
        while(top!=-1 && stack[top]<=arr[i]){
            top--;
        }
        if(top==-1)
        ans[i]=-1;
        else
        ans[i]=stack[top];

        stack[++top]=arr[i];
    }
    for(int i=0;i<n;i++){
        printf("%d ",ans[i]);
    }

    return 0;
}
