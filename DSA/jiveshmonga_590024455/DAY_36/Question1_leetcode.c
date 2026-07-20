#include <stdlib.h>
#include <stdbool.h>
#define MAX 100
typedef struct 
{
    int arr[MAX];
    int front;
    int rear;
} Queue;
typedef struct
{
    Queue q1;
    Queue q2;
}
MyStack;

void enqueue(Queue *q, int x) 
{
    q->arr[q->rear++]=x;
}
int dequeue(Queue *q) 
{
    return q->arr[q->front++];
}
bool isEmptyQueue(Queue *q) 
{
    return q->front==q->rear;
}
MyStack* myStackCreate() 
{
    MyStack *obj=(MyStack *)malloc(sizeof(MyStack));
    obj->q1.front=obj->q1.rear = 0;
    obj->q2.front=obj->q2.rear = 0;
    return obj;
}
void myStackPush(MyStack* obj,int x) {
    enqueue(&obj->q2,x);
    while (!isEmptyQueue(&obj->q1)) 
    {
        enqueue(&obj->q2, dequeue(&obj->q1));
    }
    Queue temp=obj->q1;
    obj->q1=obj->q2;
    obj->q2=temp;
}
int myStackPop(MyStack* obj) 
{
    return dequeue(&obj->q1);
}
int myStackTop(MyStack* obj) 
{
    return obj->q1.arr[obj->q1.front];
}

bool myStackEmpty(MyStack* obj) 
{
    return isEmptyQueue(&obj->q1);
}
void myStackFree(MyStack* obj) 
{
    free(obj);
}