#include <stdlib.h>
#include <stdbool.h>
#define MAX 100

typedef struct {
    int arr[MAX];
    int front;
    int rear;
    int size;
} Queue;

typedef struct {
    Queue q1;
    Queue q2;
} MyStack;

void initQueue(Queue *q) {
    q->front = 0;
    q->rear = 0;
    q->size = 0;
}
bool isEmptyQueue(Queue *q) {
    return q->size == 0;
}
void enqueue(Queue *q, int x) {
    q->arr[q->rear] = x;
    q->rear = (q->rear + 1) % MAX;
    q->size++;
}
int dequeue(Queue *q) {
    int x = q->arr[q->front];
    q->front = (q->front + 1) % MAX;
    q->size--;
    return x;
}
int frontQueue(Queue *q) {
    return q->arr[q->front];
}

MyStack* myStackCreate() {
    MyStack *obj = (MyStack *)malloc(sizeof(MyStack));
    initQueue(&obj->q1);
    initQueue(&obj->q2);
    return obj;
}
void myStackPush(MyStack* obj, int x) {
    enqueue(&obj->q2, x);

    while (!isEmptyQueue(&obj->q1)) {
        enqueue(&obj->q2, dequeue(&obj->q1));
    }

    Queue temp = obj->q1;
    obj->q1 = obj->q2;
    obj->q2 = temp;
}
int myStackPop(MyStack* obj) {
    return dequeue(&obj->q1);
}
int myStackTop(MyStack* obj) {
    return frontQueue(&obj->q1);
}
bool myStackEmpty(MyStack* obj) {
    return isEmptyQueue(&obj->q1);
}
void myStackFree(MyStack* obj) {
    free(obj);
}
