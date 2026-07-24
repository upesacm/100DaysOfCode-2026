#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#define STACK_MAX 100

typedef struct {
    int arr[STACK_MAX];
    int top;
} Stack;

typedef struct {
    Stack s1;
    Stack s2;
} MyQueue;

static void initStack(Stack *s) {
    s->top = -1;
}

static bool stackIsEmpty(Stack *s) {
    return s->top == -1;
}

static void pushStack(Stack *s, int x) {
    if (s->top == STACK_MAX - 1) {
        printf("Stack Overflow\n");
        return;
    }
    s->arr[++s->top] = x;
}

static int popStack(Stack *s) {
    if (stackIsEmpty(s)) {
        printf("Stack Underflow\n");
        return -1;
    }
    return s->arr[s->top--];
}

static int peekStack(Stack *s) {
    if (stackIsEmpty(s))
        return -1;
    return s->arr[s->top];
}

static void transfer(MyQueue *q) {
    while (!stackIsEmpty(&q->s1)) {
        pushStack(&q->s2, popStack(&q->s1));
    }
}

MyQueue* myQueueCreate() {
    MyQueue *q = (MyQueue*)malloc(sizeof(MyQueue));
    initStack(&q->s1);
    initStack(&q->s2);
    return q;
}

void myQueuePush(MyQueue* obj, int x) {
    pushStack(&obj->s1, x);
}

int myQueuePop(MyQueue* obj) {
    if (stackIsEmpty(&obj->s2))
        transfer(obj);
    return popStack(&obj->s2);
}

int myQueuePeek(MyQueue* obj) {
    if (stackIsEmpty(&obj->s2))
        transfer(obj);
    return peekStack(&obj->s2);
}

bool myQueueEmpty(MyQueue* obj) {
    return stackIsEmpty(&obj->s1) && stackIsEmpty(&obj->s2);
}

void myQueueFree(MyQueue* obj) {
    free(obj);
}