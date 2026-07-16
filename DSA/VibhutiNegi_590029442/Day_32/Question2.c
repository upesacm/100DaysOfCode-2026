#include <stdio.h>
#define MAX 100
int stack[MAX];
int copyArr[MAX];
int top = -1;
int copyTop = -1;
void push(int arr[], int *top, int x) {
    if (*top == MAX - 1) {
        printf("Stack overflow! Cannot push %d\n", x);
        return;
    }
    (*top)++;
    arr[*top] = x;
}
int pop(int arr[], int *top) {
    int x = arr[*top];
    (*top)--;
    return x;
}
int isEmpty(int top) {
    return top == -1;
}
void copyStack(int arr[], int localTop) {
    if (isEmpty(localTop)) {
        return;
    }
    int x = pop(arr, &localTop);
    copyStack(arr, localTop);
    push(copyArr, &copyTop, x);
}
int main() {
    int n, x;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &x);
        push(stack, &top, x);
    }
    copyStack(stack, top);
    printf("[");
    for (int i = 0; i <= copyTop; i++) {
        printf("%d", copyArr[i]);
        if (i != copyTop) {
            printf(",");
        }
    }
    printf("]\n");
    return 0;
}