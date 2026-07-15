#include <stdio.h>
#include <stdlib.h>
void nextGreaterElement(int arr[], int n) {
    int stack[n];
    int top = -1;
    int ans[n];
    for(int i = n - 1; i >= 0; i--){
        while (top != -1 && stack[top] <= arr[i]){
            top--;
        }
        if(top == -1){
            ans[i] = -1;
        } else{
            ans[i] = stack[top];
        } stack[++top] = arr[i];
    }
    printf("Next Greater Elements:\n");
    for(int i = 0; i < n; i++){
        printf("%d ", ans[i]);
    }
    printf("\n");
}
int main() {
    int n;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter the elements:\n");
    for(int i = 0; i < n; i++){
        scanf("%d", &arr[i]);
    }
    nextGreaterElement(arr, n);
    return 0;
}