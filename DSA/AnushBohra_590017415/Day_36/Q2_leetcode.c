#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX 1000

// Queue Structure
typedef struct {
    int arr[MAX];
    int front;
    int rear;
    int size;
} Queue;

// Stack Structure
typedef struct {
    Queue q1;
    Queue q2;
} MyStack;

// Queue Functions
void initQueue(Queue *q) {
    q->front = 0;
    q->rear = 0;
    q->size = 0;
}

bool isEmptyQueue(Queue *q) {
    return q->size == 0;
}

void enqueue(Queue *q, int x) {
    if (q->size == MAX) {
        printf("Queue Overflow!\n");
        return;
    }

    q->arr[q->rear] = x;
    q->rear = (q->rear + 1) % MAX;
    q->size++;
}

int dequeue(Queue *q) {
    if (isEmptyQueue(q)) {
        printf("Queue Underflow!\n");
        return -1;
    }

    int val = q->arr[q->front];
    q->front = (q->front + 1) % MAX;
    q->size--;

    return val;
}

int peek(Queue *q) {
    if (isEmptyQueue(q))
        return -1;

    return q->arr[q->front];
}

// Stack Functions
void initStack(MyStack *s) {
    initQueue(&s->q1);
    initQueue(&s->q2);
}

void push(MyStack *s, int x) {

    enqueue(&s->q2, x);

    while (!isEmptyQueue(&s->q1)) {
        enqueue(&s->q2, dequeue(&s->q1));
    }

    Queue temp = s->q1;
    s->q1 = s->q2;
    s->q2 = temp;
}

int pop(MyStack *s) {
    return dequeue(&s->q1);
}

int top(MyStack *s) {
    return peek(&s->q1);
}

bool empty(MyStack *s) {
    return isEmptyQueue(&s->q1);
}

// Driver Code
int main() {

    MyStack s;
    initStack(&s);

    push(&s, 10);
    push(&s, 20);
    push(&s, 30);

    printf("Top = %d\n", top(&s));

    printf("Pop = %d\n", pop(&s));
    printf("Top = %d\n", top(&s));

    push(&s, 40);

    printf("Top = %d\n", top(&s));

    while (!empty(&s)) {
        printf("%d ", pop(&s));
    }

    printf("\n");

    if (empty(&s))
        printf("Stack is Empty\n");
    else
        printf("Stack is Not Empty\n");

    return 0;
}