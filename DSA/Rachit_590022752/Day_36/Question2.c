#include <stdio.h>
#define MAX 1000

int main() {
    int n, k;
    int queue[MAX];
    int front = 0, rear = 0;
    int minute = 0;

    printf("Enter the number of people: ");
    scanf("%d", &n);

    printf("Enter the person number (k): ");
    scanf("%d", &k);

    for (int i = 1; i <= n; i++) {
        queue[rear++] = i;
    }

    while (front < rear) {
        minute++;

        int person = queue[front++];

        if (person == k) {
            printf("Person %d gets served at minute %d\n", k, minute);
            break;
        }
        if (person % 2 != 0) {
            queue[rear++] = person;
        }
    }
    return 0;
}
