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

void insertAtBottom(struct Stack *st, int x) {
    if (isEmpty(st)) {
        push(st, x);
        return;
    }

    int temp = pop(st);
    insertAtBottom(st, x);
    push(st, temp);
}

void printStack(struct Stack *st) {
    for (int i = 0; i <= st->top; i++)
        printf("%d ", st->arr[i]);
    printf("\n");
}

int main() {
    struct Stack st;
    init(&st);

    int n, x, value;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter stack elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        push(&st, value);
    }

    printf("Enter element to insert at bottom: ");
    scanf("%d", &x);

    insertAtBottom(&st, x);

    printf("Stack after insertion (bottom to top): ");
    printStack(&st);

    return 0;
}