#include <stdio.h>

#define MAX 100

struct Queue {
    int arr[MAX];
    int front;
    int rear;
};

void enqueue(struct Queue *q, int x) {
    if (q->rear == MAX) {
        printf("Queue Overflow\n");
        return;
    }
    q->arr[q->rear++] = x;
}

int dequeue(struct Queue *q) {
    if (q->front == q->rear) {
        printf("Queue Underflow\n");
        return -1;
    }
    return q->arr[q->front++];
}

int frontElement(struct Queue *q) {
    return q->arr[q->front];
}

int isEmptyQueue(struct Queue *q) {
    return q->front == q->rear;
}

struct MyStack {
    struct Queue q1;
    struct Queue q2;
};

void initStack(struct MyStack *s) {
    s->q1.front = s->q1.rear = 0;
    s->q2.front = s->q2.rear = 0;
}

void push(struct MyStack *s, int x) {

    enqueue(&s->q2, x);

    while (!isEmptyQueue(&s->q1)) {
        enqueue(&s->q2, dequeue(&s->q1));
    }

    struct Queue temp = s->q1;
    s->q1 = s->q2;
    s->q2 = temp;
}

int pop(struct MyStack *s) {
    return dequeue(&s->q1);
}

int top(struct MyStack *s) {
    return frontElement(&s->q1);
}

int empty(struct MyStack *s) {
    return isEmptyQueue(&s->q1);
}

int main() {

    struct MyStack st;
    initStack(&st);

    push(&st, 1);
    push(&st, 2);
    push(&st, 3);

    printf("Top: %d\n", top(&st));
    printf("Pop: %d\n", pop(&st));
    printf("Top: %d\n", top(&st));

    push(&st, 4);

    printf("Pop: %d\n", pop(&st));
    printf("Pop: %d\n", pop(&st));
    printf("Empty: %s\n", empty(&st) ? "true" : "false");
    printf("Pop: %d\n", pop(&st));
    printf("Empty: %s\n", empty(&st) ? "true" : "false");

    return 0;
}