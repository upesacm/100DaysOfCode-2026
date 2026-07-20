typedef struct {
    int *in;
    int *out;
    int topIn;
    int topOut;
    int capacity;
} MyQueue;
MyQueue* create() {
    MyQueue *obj = (MyQueue *)malloc(sizeof(MyQueue));
    obj->capacity = 100;
    obj->in = (int *)malloc(obj->capacity * sizeof(int));
    obj->out = (int *)malloc(obj->capacity * sizeof(int));
    obj->topIn = -1;
    obj->topOut = -1;
    return obj;
}
void push(MyQueue* obj, int x) {
    obj->in[++obj->topIn] = x;
}
int pop(MyQueue* obj) {
    if (obj->topOut == -1) {
        while(obj->topIn != -1) {
            obj->out[++obj->topOut] = obj->in[obj->topIn--];
        }
    }
    return obj->out[obj->topOut--];
}
int peek(MyQueue* obj) {
    if (obj->topOut == -1) {
        while (obj->topIn != -1) {
            obj->out[++obj->topOut] = obj->in[obj->topIn--];
        }
    }
    return obj->out[obj->topOut];
}
bool empty(MyQueue* obj) {

    return (obj->topIn == -1 && obj->topOut == -1);
}
void queueFree(MyQueue* obj) {
    free(obj->in);
    free(obj->out);
    free(obj);
}