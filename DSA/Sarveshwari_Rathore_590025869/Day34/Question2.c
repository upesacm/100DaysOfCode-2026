#include <stdio.h>
#include <stdlib.h>

void visibleLeft(int arr[],int n,int left[]){
    int stack[n];
    int top = -1;
    for(int i = 0; i < n; i++){
        left[i] = 0;

        while(top != -1 && stack[top] < arr[i]){
            top--;
            left[i]++;
        }
        if(top != -1)
            left[i]++;
        stack[++top] = arr[i];
    }
}
void visibleRight(int arr[],int n,int right[]){
    int stack[n];
    int top = -1;
    for(int i = n - 1; i >= 0; i--){
        right[i] = 0;
        while(top != -1 && stack[top] < arr[i]){
            top--;
            right[i]++;
        }
        if(top != -1){
            right[i]++;
        }
        stack[++top] = arr[i];
    }
}
int max_visible_ppl(int arr[], int n){
    int left[n],right[n];
    visibleLeft(arr, n, left);
    visibleRight(arr, n, right);
    int ans = 0;
    for(int i = 0; i < n; i++){
        int total = left[i] + right[i] + 1;
        if(total > ans){
            ans = total;
        }
    }
    return ans;
}
int main() {
    int arr[] = {6, 2, 5, 4, 5, 1, 6};
    int n = sizeof(arr)/sizeof(arr[0]);
    printf("%d", max_visible_ppl(arr, n));
    return 0;
}