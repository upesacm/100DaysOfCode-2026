#include <stdio.h>
#define MAX 100

struct Stack {
    int arr[MAX];
    int top;
};

void init(struct Stack *st) {
    st->top = -1;
}

int isEmpty(struct Stack *st) {
    return st->top == -1;
}

void push(struct Stack *st, int x) {
    if (st->top < MAX - 1)
        st->arr[++st->top] = x;
}

int pop(struct Stack *st) {
    if (!isEmpty(st))
        return st->arr[st->top--];
    return -1;
}

void copyStack(struct Stack *st, struct Stack *copy) {
    if (isEmpty(st))
        return;

    int x = pop(st);

    copyStack(st, copy);

    push(st, x);
    push(copy, x);
}

void printStack(struct Stack st) {
    while (!isEmpty(&st))
        printf("%d ", pop(&st));
    printf("\n");
}

int main() {
    struct Stack st, copied;
    init(&st);
    init(&copied);

    int n, x;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter stack elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &x);
        push(&st, x);
    }

    copyStack(&st, &copied);

    printf("Original Stack (top to bottom): ");
    printStack(st);

    printf("Copied Stack (top to bottom): ");
    printStack(copied);

    return 0;
}