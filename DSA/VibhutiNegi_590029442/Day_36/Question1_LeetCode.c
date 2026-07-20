#define MAX 100
typedef struct {
      int q1[MAX], q2[MAX];
      int front1, rear1;
      int front2, rear2;
} MyStack;
MyStack* myStackCreate() {
     MyStack* obj = (MyStack*)malloc(sizeof(MyStack));
      obj->front1 = obj->rear1 = 0;
      obj->front2 = obj->rear2 = 0;
    return obj;
}
void myStackPush(MyStack* obj, int x) {
    obj->q2[obj->rear2++] = x;
    while(obj->front1 < obj->rear1)
    {
        obj->q2[obj->rear2++] = obj->q1[obj->front1++];
    }
    obj->front1 = 0;
    obj->rear1 = 0;
    while(obj->front2 < obj->rear2)
    {
        obj->q1[obj->rear1++] = obj->q2[obj->front2++];
    }
    obj->front2 = obj->rear2 = 0;
}
int myStackPop(MyStack* obj) {
    return obj->q1[obj->front1++];
}
int myStackTop(MyStack* obj) {
    return obj->q1[obj->front1];
}
bool myStackEmpty(MyStack* obj) {
    return obj->front1 == obj->rear1;
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