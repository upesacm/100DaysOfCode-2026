#include <stdio.h>
void nextGreater(int arr[],int n) {
    int stack[n];
    int top=-1;
    int ans[n];
    for (int i=n-1;i>=0;i--) {
        while(top!=-1&&stack[top]<=arr[i]) {
            top--;
        }
        if(top==-1)
            ans[i]=-1;
        else
            ans[i]=stack[top];
        stack[++top]=arr[i];
    }
    printf("[");
    for (int i=0;i<n;i++) {
        printf("%d",ans[i]);
        if (i!=n-1)
            printf(",");
    }
    printf("]");
}
int main() 
{
    int n;
    scanf("%d",&n);
    int arr[n];
    for (int i=0;i<n;i++)
        scanf("%d", &arr[i]);
    nextGreater(arr,n);

    return 0;
}