#include <stdio.h>

#define SIZE 10000

typedef struct {
    int queue[SIZE];
    int front;
    int rear;
} RecentCounter;


void init(RecentCounter *rc) {
    rc->front = 0;
    rc->rear = 0;
}


int ping(RecentCounter *rc, int t) {

    rc->queue[rc->rear++] = t;

    while (rc->front < rc->rear &&
           rc->queue[rc->front] < t - 3000) {
        rc->front++;
    }

    return rc->rear - rc->front;
}

int main() {
    RecentCounter rc;
    init(&rc);

    printf("%d\n", ping(&rc, 1));
    printf("%d\n", ping(&rc, 100));
    printf("%d\n", ping(&rc, 3001));
    printf("%d\n", ping(&rc, 3002));

    return 0;
}