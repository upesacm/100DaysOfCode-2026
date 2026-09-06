#include <stdio.h>
#define SIZE 100
int heap[SIZE];
int heapSize = 0;
void swap(int *a, int *b) {
    int t = *a;
    *a = *b;
    *b = t;
}
void insert(int value) {
    heap[heapSize] = value;
    int cur = heapSize++;
    while (cur > 0) {
        int par = (cur - 1) / 2;
        if (heap[cur] > heap[par]) {
            swap(&heap[cur], &heap[par]);
            cur = par;
        } else {
            break;
        }
    }
}
void heapifyDown(int idx) {
    int largest = idx;
    int l = 2 * idx + 1;
    int r = 2 * idx + 2;
    if (l < heapSize && heap[l] > heap[largest])
        largest = l;
    if (r < heapSize && heap[r] > heap[largest])
        largest = r;
    if (largest != idx) {
        swap(&heap[idx], &heap[largest]);
        heapifyDown(largest);
    }
}
int extractMax() {
    if (heapSize == 0)
        return -1;
    int maxVal = heap[0];
    heap[0] = heap[--heapSize];
    if (heapSize > 0)
        heapifyDown(0);
    return maxVal;
}
void display() {
    printf("Heap: ");
    for (int i = 0; i < heapSize; i++)
        printf("%d ", heap[i]);
    printf("\n");
}
int main() {
    insert(40);
    insert(25);
    insert(50);
    insert(10);
    insert(60);
    display();
    printf("Extracted: %d\n", extractMax());
    display();
    return 0;
}