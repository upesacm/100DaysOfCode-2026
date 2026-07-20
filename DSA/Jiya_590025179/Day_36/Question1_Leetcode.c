
typedef struct{
    int q1[100];
    int q2[100];
    int f1,r1;
    int f2,r2;
}MyStack;

MyStack* myStackCreate(){
    MyStack* a=(MyStack*)malloc(sizeof(MyStack));
    a->f1=a->r1=0;
    a->f2=a->r2=0;
    return a;
}

void myStackPush(MyStack* a,int x){
    a->q2[a->r2++]=x;
    while(a->f1<a->r1)
        a->q2[a->r2++]=a->q1[a->f1++];
    int temp[100];
    int size=a->r2;
    for(int i=0;i<size;i++)
        temp[i]=a->q2[i];
    for(int i=0;i<size;i++)
        a->q1[i]=temp[i];
    a->f1=0;
    a->r1=size;
    a->f2=0;
    a->r2=0;
}

int myStackPop(MyStack* a){
    return a->q1[a->f1++];
}

int myStackTop(MyStack* a){
    return a->q1[a->f1];
}

bool myStackEmpty(MyStack* a){
    return a->f1==a->r1;
}

void myStackFree(MyStack* a){
    free(a);
}
