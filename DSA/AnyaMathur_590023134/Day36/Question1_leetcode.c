// Leetcode Problem 225
// Implement Stack using Queues 

#define MAX 100


typedef struct {
    int q1[MAX];
    int q2[MAX];
    int front1;
    int rear1;
    int front2;
    int rear2; 
} MyStack;


MyStack* myStackCreate() {
    MyStack *obj = (MyStack *)malloc(sizeof(MyStack));
    obj->front1 = 0;
    obj->rear1 = -1;
    obj->front2 = 0;
    obj->rear2 = -1;
    return obj;
}

void myStackPush(MyStack* obj, int x) {
    obj->rear2++;
    obj->q2[obj->rear2] = x;
    while(obj->front1 <= obj->rear1) {
        obj->rear2++;
        obj->q2[obj->rear2] = obj->q1[obj->front1];
        obj->front1++;
    }
    obj->front2 = 0;
    obj->front1 = 0;
    obj->rear1 = -1;
    while(obj->front2 <= obj->rear2) {
        obj->rear1++;
        obj->q1[obj->rear1] = obj->q2[obj->front2];
        obj->front2++;
    }
    obj->front2 = 0;
    obj->rear2 = -1;
}

int myStackPop(MyStack* obj) {
    int value = obj->q1[obj->front1];
    obj->front1++;
    return value;
}

int myStackTop(MyStack* obj) {
    int value = obj->q1[obj->front1];
    return value;
}

bool myStackEmpty(MyStack* obj) {
    if(obj->front1 > obj->rear1) {
        return true;
    }
    return false;
}

void myStackFree(MyStack* obj) {
    free(obj);
}

/**
 * Your MyStack struct will be instantiated and called as such:
 * MyStack* obj = myStackCreate();
 * myStackPush(obj, x);
 
 * int param_2 = myStackPop(obj);
 
 * int param_3 = myStackTop(obj);
 
 * bool param_4 = myStackEmpty(obj);
 
 * myStackFree(obj);
*/