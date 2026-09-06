#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    int stack1[100];
    int stack2[100];
    int top1;
    int top2;
} MyQueue;

MyQueue* myQueueCreate() {
    MyQueue* obj = (MyQueue*)malloc(sizeof(MyQueue));
    obj->top1 = -1;
    obj->top2 = -1;
    return obj;
}

void myQueuePush(MyQueue* obj, int x) {
    obj->stack1[++obj->top1] = x;
}

int myQueuePop(MyQueue* obj) {
    // If stack2 is empty, transfer elements from stack1
    if (obj->top2 == -1) {
        while (obj->top1 >= 0) {
            obj->stack2[++obj->top2] = obj->stack1[obj->top1--];
        }
    }

    return obj->stack2[obj->top2--];
}

int myQueuePeek(MyQueue* obj) {
    // If stack2 is empty, transfer elements from stack1
    if (obj->top2 == -1) {
        while (obj->top1 >= 0) {
            obj->stack2[++obj->top2] = obj->stack1[obj->top1--];
        }
    }

    return obj->stack2[obj->top2];
}

bool myQueueEmpty(MyQueue* obj) {
    return (obj->top1 == -1 && obj->top2 == -1);
}

void myQueueFree(MyQueue* obj) {
    free(obj);
}