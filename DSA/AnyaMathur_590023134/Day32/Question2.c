// Problem 2
// Copy From One Stack To Another

#include <stdio.h>
#define MAX 100

int stack[MAX];
int copy[MAX];

int top = -1;
int copyTop = -1;

void push(int arr[], int *top, int x) {
    (*top)++;
    arr[*top] = x;
}

int pop(int arr[], int *top) {

    int x = arr[*top];
    (*top)--;

    return x;
}

int peek(int arr[], int top) {
    return arr[top];
}

int isEmpty(int top) {
    if(top == -1)
        return 1;
    else
        return 0;
}

void copyStack(int arr[], int top) {
    if(isEmpty(top))
        return;
    int x = pop(arr, &top);
    copyStack(arr, top);
    push(copy, &copyTop, x);
}

int main() {
    int n, x;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter stack elements: ");

    for(int i = 0; i < n; i++) {
        scanf("%d", &x);
        push(stack, &top, x);
    }

    copyStack(stack, top);

    printf("Copied Stack: ");
    for(int i = 0; i <= copyTop; i++) {
        printf("%d ", copy[i]);
    }

    return 0;
}