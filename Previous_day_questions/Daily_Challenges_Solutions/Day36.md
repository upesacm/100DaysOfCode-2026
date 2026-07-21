<h2 align="center">Week 6 Day 36 (20/07/2026)</h2>

## 1. Implement Stack using Queues (LeetCode #225)
### Solution
```c
#define MAXSIZE 105

typedef struct {
    int data[MAXSIZE];
    int front, rear, size;
} Queue;

void initQueue(Queue *q) {
    q->front = 0;
    q->rear = -1;
    q->size = 0;
}

void enqueue(Queue *q, int x) {
    q->rear = (q->rear + 1) % MAXSIZE;
    q->data[q->rear] = x;
    q->size++;
}

int dequeue(Queue *q) {
    int val = q->data[q->front];
    q->front = (q->front + 1) % MAXSIZE;
    q->size--;
    return val;
}

typedef struct {
    Queue q;
} MyStack;

// Initialize the stack
void myStackInit(MyStack *st) {
    initQueue(&st->q);
}

// Push x, then rotate so x moves to the front -> O(n)
void myStackPush(MyStack *st, int x) {
    enqueue(&st->q, x);
    int n = st->q.size;
    for (int i = 0; i < n - 1; i++)
        enqueue(&st->q, dequeue(&st->q));
}

// Remove and return the top element
int myStackPop(MyStack *st) {
    return dequeue(&st->q);
}

// Return the top element without removing it
int myStackTop(MyStack *st) {
    return st->q.data[st->q.front];
}

// Check whether the stack is empty
int myStackEmpty(MyStack *st) {
    return st->q.size == 0;
}

/**
 * Your MyStack struct will be instantiated and called as such:
 * MyStack st;
 * myStackInit(&st);
 * myStackPush(&st, x);
 *
 * int param_2 = myStackPop(&st);
 *
 * int param_3 = myStackTop(&st);
 *
 * int param_4 = myStackEmpty(&st);
 */
```
---
## 2. Ticket Counter Queue
### Solution
```c
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int id;
    int visited;
} Person;

int ticketMinute(int n, int k) {
    int capacity = n;
    Person *queue = (Person *)malloc(capacity * sizeof(Person));

    // Initialize queue with people numbered 1 to n
    for (int i = 0; i < n; i++) {
        queue[i].id = i + 1;
        queue[i].visited = 0;
    }

    int front = 0, rear = n - 1, size = n;
    int minute = 0, result = -1;
    int firstServe = 1;

    while (size > 0) {
        Person p = queue[front];

        if (firstServe) {
            // First person is always served unconditionally
            front = (front + 1) % capacity;
            size--;
            minute++;
            if (p.id == k) { result = minute; break; }
            firstServe = 0;
            continue;
        }

        if (p.id % 2 == 0 || p.visited || size == 1) {
            // Serve this person
            front = (front + 1) % capacity;
            size--;
            minute++;
            if (p.id == k) { result = minute; break; }
        } else {
            // Odd and not yet skipped -> move to back
            front = (front + 1) % capacity;
            p.visited = 1;
            rear = (rear + 1) % capacity;
            queue[rear] = p;
        }
    }

    free(queue);
    return result;
}

int main() {
    int n, k;
    printf("Enter n and k: ");
    scanf("%d %d", &n, &k);
    printf("Person %d is served at minute %d\n", k, ticketMinute(n, k));
    return 0;
}
```
