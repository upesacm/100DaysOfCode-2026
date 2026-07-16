#include <stdio.h>

#define MAX 100

struct Stack {
    int arr[MAX];
    int top;
};

void push(struct Stack *s, int x) {
    if (s->top == MAX - 1) {
        printf("Stack Overflow\n");
        return;
    }
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

void insertAtBottom(struct Stack *s, int x) {

    if (isEmpty(s)) {
        push(s, x);
        return;
    }

    int temp = pop(s);

    insertAtBottom(s, x);

    push(s, temp);
}

void printStack(struct Stack *s) {

    for (int i = s->top; i >= 0; i--)
        printf("%d ", s->arr[i]);

    printf("\n");
}

int main() {

    struct Stack s;
    s.top = -1;

    push(&s, 1);
    push(&s, 2);
    push(&s, 3);
    push(&s, 4);

    printf("Original Stack (Top to Bottom): ");
    printStack(&s);

    int x = 10;

    insertAtBottom(&s, x);

    printf("After Inserting at Bottom: ");
    printStack(&s);

    return 0;
}