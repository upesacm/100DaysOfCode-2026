#include <stdio.h>
#include <string.h>

#define MAX 100

typedef struct {
    int q1[MAX];
    int q2[MAX];
    int front1, rear1;
    int front2, rear2;
} MyStack;

void initStack(MyStack *s) {
    s->front1 = 0;
    s->rear1 = -1;
    s->front2 = 0;
    s->rear2 = -1;
}

void push(MyStack *s, int x) {
    s->q2[++s->rear2] = x;

    while (s->front1 <= s->rear1) {
        s->q2[++s->rear2] = s->q1[s->front1++];
    }

    for (int i = s->front2; i <= s->rear2; i++) {
        s->q1[i - s->front2] = s->q2[i];
    }

    s->rear1 = s->rear2 - s->front2;
    s->front1 = 0;

    s->front2 = 0;
    s->rear2 = -1;
}

int pop(MyStack *s) {
    return s->q1[s->front1++];
}

int top(MyStack *s) {
    return s->q1[s->front1];
}

int empty(MyStack *s) {
    return s->front1 > s->rear1;
}

int main() {
    MyStack stack;
    initStack(&stack);

    int n, x;
    char operation[10];

    printf("Enter number of operations: ");
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        printf("Enter operation (push, pop, top, empty): ");
        scanf("%s", operation);

        if (strcmp(operation, "push") == 0) {
            printf("Enter value to push: ");
            scanf("%d", &x);
            push(&stack, x);
            printf("null\n");
        }
        else if (strcmp(operation, "pop") == 0) {
            printf("%d\n", pop(&stack));
        }
        else if (strcmp(operation, "top") == 0) {
            printf("%d\n", top(&stack));
        }
        else if (strcmp(operation, "empty") == 0) {
            if (empty(&stack))
                printf("true\n");
            else
                printf("false\n");
        }
        else {
            printf("Invalid operation\n");
        }
    }

    return 0;
}