
#define Max 200

typedef struct {
    int q[Max];
    int front;
    int rear;
} MyStack;


MyStack* myStackCreate() {
    MyStack *obj=malloc(sizeof(MyStack));
    obj->front=0;
    obj->rear=-1;
    return obj;
}

void myStackPush(MyStack* obj, int x) {
    obj->q[++obj->rear]=x;
    int n=obj->rear-obj->front+1;
    for(int i=0;i<n-1;i++){
        int temp=obj->q[obj->front++];
        obj->q[++obj->rear]=temp;
    }
    int j=0;
    for (int i=obj->front;i <= obj->rear;i++) {
        obj->q[j++]=obj->q[i];
    }

    obj->front=0;
    obj->rear=j-1;
}

int myStackPop(MyStack* obj) {
    int x=obj->q[obj->front];
    for(int i=obj->front+1;i<=obj->rear;i++){
        obj->q[i-1]=obj->q[i];
    }
    obj->rear--;
    return x;
}

int myStackTop(MyStack* obj) {
    return obj->q[obj->front];
}

bool myStackEmpty(MyStack* obj) {
    return obj->rear==-1;
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
