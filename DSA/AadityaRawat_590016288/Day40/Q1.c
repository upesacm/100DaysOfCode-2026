#include <stdlib.h>

typedef struct {
    int arr[1005];
    int size;
} FrontMiddleBackQueue;

FrontMiddleBackQueue* frontMiddleBackQueueCreate() {
    FrontMiddleBackQueue* obj = (FrontMiddleBackQueue*)malloc(sizeof(FrontMiddleBackQueue));
    obj->size = 0;
    return obj;
}

void frontMiddleBackQueuePushFront(FrontMiddleBackQueue* obj, int val) {
    for (int i = obj->size; i > 0; i--)
        obj->arr[i] = obj->arr[i - 1];
    obj->arr[0] = val;
    obj->size++;
}

void frontMiddleBackQueuePushBack(FrontMiddleBackQueue* obj, int val) {
    obj->arr[obj->size++] = val;
}

void frontMiddleBackQueuePushMiddle(FrontMiddleBackQueue* obj, int val) {
    int mid = obj->size / 2;
    for (int i = obj->size; i > mid; i--)
        obj->arr[i] = obj->arr[i - 1];
    obj->arr[mid] = val;
    obj->size++;
}

int frontMiddleBackQueuePopFront(FrontMiddleBackQueue* obj) {
    if (obj->size == 0)
        return -1;

    int val = obj->arr[0];
    for (int i = 0; i < obj->size - 1; i++)
        obj->arr[i] = obj->arr[i + 1];
    obj->size--;
    return val;
}

int frontMiddleBackQueuePopBack(FrontMiddleBackQueue* obj) {
    if (obj->size == 0)
        return -1;

    return obj->arr[--obj->size];
}

int frontMiddleBackQueuePopMiddle(FrontMiddleBackQueue* obj) {
    if (obj->size == 0)
        return -1;

    int mid = (obj->size - 1) / 2;
    int val = obj->arr[mid];

    for (int i = mid; i < obj->size - 1; i++)
        obj->arr[i] = obj->arr[i + 1];

    obj->size--;
    return val;
}

void frontMiddleBackQueueFree(FrontMiddleBackQueue* obj) {
    free(obj);
}