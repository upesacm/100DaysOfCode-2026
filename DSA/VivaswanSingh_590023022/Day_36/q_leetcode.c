#define MAX 100

typedef struct
{
    int q1[MAX];
    int q2[MAX];
    int front1, rear1;
    int front2, rear2;
} MyStack;

MyStack* myStackCreate()
{
    MyStack *obj = (MyStack *)malloc(sizeof(MyStack));

    obj->front1 = obj->rear1 = 0;
    obj->front2 = obj->rear2 = 0;

    return obj;
}

void myStackPush(MyStack* obj, int x)
{
    obj->q2[obj->rear2++] = x;

    while (obj->front1 < obj->rear1)
    {
        obj->q2[obj->rear2++] = obj->q1[obj->front1++];
    }

    int tempFront = obj->front1;
    int tempRear = obj->rear1;
    int temp[MAX];

    for (int i = 0; i < obj->rear2; i++)
        temp[i] = obj->q2[i];

    for (int i = 0; i < obj->rear2; i++)
        obj->q1[i] = temp[i];

    obj->front1 = 0;
    obj->rear1 = obj->rear2;

    obj->front2 = 0;
    obj->rear2 = 0;
}

int myStackPop(MyStack* obj)
{
    return obj->q1[obj->front1++];
}

int myStackTop(MyStack* obj)
{
    return obj->q1[obj->front1];
}

bool myStackEmpty(MyStack* obj)
{
    return obj->front1 == obj->rear1;
}

void myStackFree(MyStack* obj)
{
    free(obj);
}