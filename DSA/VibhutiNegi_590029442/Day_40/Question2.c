#include <stdio.h>
#define MAX 100000
int main() {
    int n, k;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int arr[MAX];
    printf("Enter elements: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);
    printf("Enter window size: ");
    scanf("%d", &k);
    int dq[MAX];
    int front = 0, rear = -1;
    for (int i = 0; i < n; i++) {
        while (front <= rear && dq[front] <= i - k)
            front++;
        while (front <= rear && arr[dq[rear]] <= arr[i])
            rear--;
        dq[++rear] = i;
        if (i >= k - 1)
            printf("%d ", arr[dq[front]]);
    }
    return 0;
}