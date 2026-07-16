#include <stdio.h>

#define MAXSIZE 1000

typedef struct {
    int arr[MAXSIZE];
    int top;
} Stack;

void push(Stack* s, int val) {
    s->arr[++(s->top)] = val;
}

int pop(Stack* s) {
    return s->arr[(s->top)--];
}

int isEmpty(Stack* s) {
    return s->top == -1;
}

void insertAtBottom(Stack* s, int x) {
    if (isEmpty(s)) {
        push(s, x);
        return;
    }
    int top = pop(s);
    insertAtBottom(s, x);
    push(s, top);
}

void printStack(Stack* s) {
    for (int i = 0; i <= s->top; i++)
        printf("%d ", s->arr[i]);
    printf("\n");
}

int main() {
    Stack s;
    s.top = -1;
    push(&s, 1);
    push(&s, 2);
    push(&s, 3);
    push(&s, 4);

    insertAtBottom(&s, 5);
    printStack(&s);  // 5 1 2 3 4

    return 0;
}