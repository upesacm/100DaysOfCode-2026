#define MAX 10000
typedef struct{
    int q[MAX];
    int front;
    int rear;
} RecentCounter;
RecentCounter* recentCounterCreate(){
    RecentCounter* obj = (RecentCounter*)malloc(sizeof(RecentCounter));
    obj->front = 0;
    obj->rear = -1;
    return obj;
}
int recentCounterPing(RecentCounter* obj, int t){
    obj->q[++(obj->rear)] = t;
    while(obj->q[obj->front] < t - 3000){
        obj->front++;
    }
    return obj->rear - obj->front + 1;
}
void recentCounterFree(RecentCounter* obj){
    free(obj);
}