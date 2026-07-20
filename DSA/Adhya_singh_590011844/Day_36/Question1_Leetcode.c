#include <stdio.h>

#define SIZE 100

// Stack implemented using two queues
typedef struct {
    int q1[SIZE], q2[SIZE];
    int front1, rear1;
    int front2, rear2;
} MyStack;

void init(MyStack *st) {
    st->front1 = st->rear1 = 0;
    st->front2 = st->rear2 = 0;
}

void push(MyStack *st, int x) {
    st->q2[st->rear2++] = x;

    while (st->front1 < st->rear1)
        st->q2[st->rear2++] = st->q1[st->front1++];

    st->front1 = 0;
    st->rear1 = st->rear2;

    for (int i = 0; i < st->rear2; i++)
        st->q1[i] = st->q2[i];

    st->front2 = st->rear2 = 0;
}

int pop(MyStack *st) {
    return st->q1[st->front1++];
}

int top(MyStack *st) {
    return st->q1[st->front1];
}

int empty(MyStack *st) {
    return st->front1 == st->rear1;
}

int main() {
    MyStack st;
    init(&st);

    push(&st, 1);
    push(&st, 2);
    push(&st, 3);

    printf("Top: %d\n", top(&st));
    printf("Pop: %d\n", pop(&st));
    printf("Top: %d\n", top(&st));

    if (empty(&st))
        printf("Stack is Empty\n");
    else
        printf("Stack is Not Empty\n");

    return 0;
}