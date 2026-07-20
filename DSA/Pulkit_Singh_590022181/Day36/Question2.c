#include <stdio.h>

#define MAX 100

int q[MAX];
int front = 0;
int rear = -1;

// Queue operations
void enqueue(int x) {
    q[++rear] = x;
}

int dequeue() {
    return q[front++];
}

int size() {
    return rear - front + 1;
}

int empty() {
    return front > rear;
}

// Stack operations
void push(int x) {

    int n = size();

    enqueue(x);

    while (n--) {
        enqueue(dequeue());
    }
}

int pop() {

    if (empty()) {
        printf("Stack Underflow\n");
        return -1;
    }

    return dequeue();
}

int topElement() {

    if (empty()) {
        printf("Stack is Empty\n");
        return -1;
    }

    return q[front];
}

int main() {

    push(1);
    push(2);
    push(3);

    printf("Top = %d\n", topElement());
    printf("Pop = %d\n", pop());
    printf("Top = %d\n", topElement());

    if (empty())
        printf("Stack is Empty\n");
    else
        printf("Stack is Not Empty\n");

    return 0;
}