#include <stdio.h>
int main(){
    int n;
    printf("Enter the number of elements: ");
    scanf("%d", &n);
    int arr[n], ans[n], stack[n];
    int top = -1;
    printf("Enter the elements: ");
    for (int i = 0; i < n; i++){
        scanf("%d", &arr[i]);
        ans[i] = -1;
    }
    for (int i = n - 1; i >= 0; i--){
        while (top != -1 && stack[top] <= arr[i]){
            top--;
        }
        if (top != -1){
            ans[i] = stack[top];
        }
        stack[++top] = arr[i];
    }
    printf("Next Greater Elements: ");
    for (int i = 0; i < n; i++){
        printf("%d ", ans[i]);
    }
    return 0;
}