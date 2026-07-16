#include <stdio.h>

void nextGreaterElement(int arr[], int n){
    int stack[n], result[n], top = -1;
    for(int i = n - 1; i >= 0; i--){
        while(top != -1 && stack[top] <= arr[i]){
            top--;
        }
        if(top == -1)
            result[i] = -1;
        else
            result[i] = stack[top];
        stack[++top] = arr[i];
    }
    for(int i = 0; i < n; i++){
        printf("%d -> %d\n", arr[i], result[i]);
    }
}

int main(){
    int n;
    scanf("%d", &n);
    int arr[n];
    for(int i = 0; i < n; i++){
        scanf("%d", &arr[i]);
    }
    nextGreaterElement(arr, n);
    return 0;
}