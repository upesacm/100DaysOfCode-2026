#include <stdio.h>
int main() {
    int n;
    printf("Enter the number of elements:");
    scanf("%d", &n);
    int arr[n], res[n];
    for (int i=0;i<n;i++){
        printf("Enter the element:");
        scanf("%d", &arr[i]);
    }
    int stack[n];
    int top=-1;
    for (int i=n-1;i>=0;i--){
        while (top>=0&&stack[top]<=arr[i]){
            top--;
        }
        if (top==-1) 
            res[i]=-1;
        else res[i]=stack[top];

        stack[++top]=arr[i];
    }
    printf("[");
    for (int i=0;i<n;i++){
        printf("%d", res[i]);
        if (i<n-1) 
            printf(",");
    }
    printf("]\n");
    return 0;
}
