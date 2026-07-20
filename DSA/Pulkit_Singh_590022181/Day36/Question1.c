#include <stdio.h>

#define MAX 100

int queue[MAX];
int front = 0;
int rear = -1;

// Queue operations
void enqueue(int x) {
    queue[++rear] = x;
}

int dequeue() {
    return queue[front++];
}

int size() {
    return rear - front + 1;
}

int isEmpty() {
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

    if (isEmpty()) {
        printf("Stack Underflow\n");
        return -1;
    }

    return dequeue();
}

int topElement() {

    if (isEmpty()) {
        printf("Stack Empty\n");
        return -1;
    }

    return queue[front];
}

int main() {

    push(1);
    push(2);

    printf("Top = %d\n", topElement());
    printf("Pop = %d\n", pop());

    if (isEmpty())
        printf("Stack is Empty\n");
    else
        printf("Stack is Not Empty\n");

    return 0;
}