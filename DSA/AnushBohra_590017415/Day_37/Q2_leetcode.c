#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int queue[10000];
    int front;
    int rear;
} RecentCounter;

RecentCounter* recentCounterCreate() {
    RecentCounter* obj = (RecentCounter*)malloc(sizeof(RecentCounter));
    obj->front = 0;
    obj->rear = 0;
    return obj;
}

int recentCounterPing(RecentCounter* obj, int t) {
    obj->queue[obj->rear++] = t;
    
    while (obj->queue[obj->front] < t - 3000) {
        obj->front++;
    }
    
    return obj->rear - obj->front;
}

void recentCounterFree(RecentCounter* obj) {
    free(obj);
}

int main() {
    RecentCounter* recentCounter = recentCounterCreate();

    printf("%d\n", recentCounterPing(recentCounter, 1));    
    printf("%d\n", recentCounterPing(recentCounter, 100));  
    printf("%d\n", recentCounterPing(recentCounter, 3001)); 
    printf("%d\n", recentCounterPing(recentCounter, 3002)); 

    recentCounterFree(recentCounter);
    return 0;
}