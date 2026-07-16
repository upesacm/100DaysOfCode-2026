#include <stdio.h>

#define MAX 100

struct Stack {
    int arr[MAX];
    int top;
};

void push(struct Stack *s, int x) {
    if (s->top == MAX - 1)
        return;

    s->arr[++(s->top)] = x;
}

int pop(struct Stack *s) {
    if (s->top == -1)
        return -1;

    return s->arr[(s->top)--];
}

int isEmpty(struct Stack *s) {
    return s->top == -1;
}

void copyStack(struct Stack *original, struct Stack *copy) {

    if (isEmpty(original))
        return;

    int temp = pop(original);

    copyStack(original, copy);

    push(original, temp);
    push(copy, temp);
}

void printStack(struct Stack *s) {

    for (int i = s->top; i >= 0; i--)
        printf("%d ", s->arr[i]);

    printf("\n");
}

int main() {

    struct Stack original, copy;

    original.top = -1;
    copy.top = -1;

    push(&original, 10);
    push(&original, 20);
    push(&original, 30);
    push(&original, 40);

    printf("Original Stack (Top to Bottom): ");
    printStack(&original);

    copyStack(&original, &copy);

    printf("Copied Stack (Top to Bottom): ");
    printStack(&copy);

    return 0;
}