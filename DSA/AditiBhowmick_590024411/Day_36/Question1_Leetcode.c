#include <stdio.h>
#define MAX 100

// Queue structure
typedef struct {
    int arr[MAX];
    int front, rear;
} Queue;

Queue q1 = {.front = 0, .rear = -1};
Queue q2 = {.front = 0, .rear = -1};

// Queue functions
int isEmpty(Queue *q) {
    return q->front > q->rear;
}

void enqueue(Queue *q, int x) {
    if (q->rear == MAX - 1)
        return;
    q->arr[++q->rear] = x;
}

int dequeue(Queue *q) {
    if (isEmpty(q))
        return -1;
    return q->arr[q->front++];
}

// Stack operations
void push(int x) {
    enqueue(&q2, x);

    while (!isEmpty(&q1)) {
        enqueue(&q2, dequeue(&q1));
    }

    Queue temp = q1;
    q1 = q2;
    q2 = temp;

    q2.front = 0;
    q2.rear = -1;
}

int pop() {
    return dequeue(&q1);
}

int top() {
    if (isEmpty(&q1))
        return -1;
    return q1.arr[q1.front];
}
int empty() {
    return isEmpty(&q1);
}

int main() {
    push(1);
    push(2);

    printf("Top: %d\n", top());
    printf("Pop: %d\n", pop());

    if (empty())
        printf("true\n");
    else
        printf("false\n");
    return 0;
}
