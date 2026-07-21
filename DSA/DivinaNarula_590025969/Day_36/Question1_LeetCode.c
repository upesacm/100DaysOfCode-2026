// Implement Stack using Queues

#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    int queue1[100];
    int queue2[100];
    int size;
} MyStack;


MyStack* myStackCreate() {
    MyStack* obj = (MyStack*)malloc(sizeof(MyStack));
    obj->size = 0;
    return obj;
}


void myStackPush(MyStack* obj, int x) {
    int i;

    // Put new element into queue2
    obj->queue2[0] = x;

    // Move all elements from queue1 to queue2
    for (i = 0; i < obj->size; i++) {
        obj->queue2[i + 1] = obj->queue1[i];
    }

    // Copy queue2 back to queue1
    for (i = 0; i <= obj->size; i++) {
        obj->queue1[i] = obj->queue2[i];
    }

    obj->size++;
}


int myStackPop(MyStack* obj) {
    int value = obj->queue1[0];
    int i;

    // Shift elements to remove the front element
    for (i = 1; i < obj->size; i++) {
        obj->queue1[i - 1] = obj->queue1[i];
    }

    obj->size--;

    return value;
}


int myStackTop(MyStack* obj) {
    return obj->queue1[0];
}


bool myStackEmpty(MyStack* obj) {
    return obj->size == 0;
}


void myStackFree(MyStack* obj) {
    free(obj);
}

/**
 * Your MyStack struct will be instantiated and called as such:
 * MyStack* obj = myStackCreate();
 * myStackPush(obj, x);
 *
 * int param_2 = myStackPop(obj);
 *
 * int param_3 = myStackTop(obj);
 *
 * bool param_4 = myStackEmpty(obj);
 *
 * myStackFree(obj);
 */