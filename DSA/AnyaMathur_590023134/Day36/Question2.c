// Problem 2 
// Ticket Counter Queue

#include <stdio.h>
#define MAX 500

typedef struct
{
    int arr[MAX];
    int front;
    int rear;
} Queue;

Queue q;

void enqueue(int value) {
    q.arr[q.rear] = value;
    q.rear = q.rear + 1;
}

int dequeue() {
    int value;
    value = q.arr[q.front];
    q.front = q.front + 1;
    return value;
}

int peek() {
    int value;
    value = q.arr[q.front];
    return value;
}

int isEmpty() {
    if (q.front == q.rear) {
        return 1;
    }
    else {
        return 0;
    }
}

int ticketCounter(int n, int k) {
    int time;
    int answer;
    int current;
    int nextPerson;
    time = 0;
    answer = 0;
    q.front = 0;
    q.rear = 0;

    for (int i = 1; i <= n; i++) {
        enqueue(i);
    }
    while (isEmpty() == 0) {
        time = time + 1;
        current = dequeue();
        if (current == k) {
            answer = time;
            break;
        }
        if (isEmpty() == 0) {
            nextPerson = peek();
            if (nextPerson % 2 == 1) {
                nextPerson = dequeue();
                enqueue(nextPerson);
            }
        }
    }
    return answer;
}

int main() {
    int n;
    int k;
    int answer;

    printf("Enter n (number of people) and k (target person): ");
    scanf("%d %d", &n, &k);
    
    answer = ticketCounter(n, k);
    printf("Ticket received at minute %d", answer);
    return 0;
}