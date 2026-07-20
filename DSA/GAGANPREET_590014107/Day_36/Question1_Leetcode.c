#define MAX 100000

typedef struct {
    int queue[MAX];
    int front;
    int rear;
} MyStack;

MyStack* myStackCreate() {
    MyStack* obj = (MyStack*)malloc(sizeof(MyStack));
    obj->front = 0;
    obj->rear = 0;
    return obj;
}

void myStackPush(MyStack* obj, int x) {
    obj->queue[obj->rear++] = x;

    int size = obj->rear - obj->front;

    for (int i = 0; i < size - 1; i++) {
        obj->queue[obj->rear++] = obj->queue[obj->front++];
    }
}

int myStackPop(MyStack* obj) {
    return obj->queue[obj->front++];
}

int myStackTop(MyStack* obj) {
    return obj->queue[obj->front];
}

int myStackEmpty(MyStack* obj) {
    return obj->front == obj->rear;
}

void myStackFree(MyStack* obj) {
    free(obj);
}
