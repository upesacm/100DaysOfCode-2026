typedef struct {
    int q1[100];
    int q2[100];
    int b1, t1;
    int b2, t2;
} MyStack;

MyStack* myStackCreate(){
    MyStack *obj = (MyStack *)malloc(sizeof(MyStack));
    obj->b1 = 0;
    obj->t1 = -1;
    obj->b2 = 0;
    obj->t2 = -1;
    return obj;
}
void myStackPush(MyStack* obj, int x){
    obj->q2[++obj->t2] = x;
    while (obj->b1 <= obj->t1){
        obj->q2[++obj->t2] = obj->q1[obj->b1++];
    }
    obj->b1 = 0;
    obj->t1 = -1;
    while (obj->b2 <= obj->t2){
        obj->q1[++obj->t1] = obj->q2[obj->b2++];
    
    obj->b2 = 0;
    obj->t2 = -1;
    }
}
int myStackPop(MyStack* obj){
    return obj->q1[obj->b1++];
}
int myStackTop(MyStack* obj){
    return obj->q1[obj->b1];
}
bool myStackEmpty(MyStack* obj){
    return obj->b1 > obj->t1;
}
void myStackFree(MyStack* obj){
    free(obj);
}