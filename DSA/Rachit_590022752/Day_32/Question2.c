#include <stdio.h>
#define MAX 100

typedef struct {
    int arr[MAX];
    int top;
} Stack;

void push(Stack *s, int value) {
    s->arr[++s->top] = value;
}

int pop(Stack *s) {
    return s->arr[s->top--];
}

int isEmpty(Stack *s) {
    return s->top == -1;
}

void display(Stack *s) {
    Stack temp;
    temp.top = -1;

    while (!isEmpty(s)) {
        push(&temp, pop(s));
    }

    while (!isEmpty(&temp)) {
        int element = pop(&temp);
        printf("%d ", element);
        push(s, element);
    }

    printf("\n");
}

int main() {
    Stack original, copied, helper;
    original.top = copied.top = helper.top = -1;

    int n, value;

    printf("Enter the number of elements: ");
    scanf("%d", &n);

    printf("Enter the stack elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        push(&original, value);
    }

    while (!isEmpty(&original)) {
        push(&helper, pop(&original));
    }

    while (!isEmpty(&helper)) {
        value = pop(&helper);
        push(&original, value);
        push(&copied, value);
    }

    printf("\nOriginal Stack (Top to Bottom): ");
    display(&original);

    printf("Copied Stack (Top to Bottom): ");
    display(&copied);

    return 0;
}
