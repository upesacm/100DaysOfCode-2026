#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
};

struct Node* deleteLastNode(struct Node* head) {
    if (head == NULL) {
        return NULL;
    }
    
    if (head->next == NULL) {
        free(head);
        return NULL;
    }
    
    struct Node* tail = head;
    while (tail->next != NULL) {
        tail = tail->next;
    }
    
    struct Node* secondLast = tail->prev;
    secondLast->next = NULL;
    
    free(tail);
    
    return head;
}

struct Node* createDLL(int* arr, int size) {
    if (size == 0) return NULL;
    
    struct Node* head = (struct Node*)malloc(sizeof(struct Node));
    head->data = arr[0];
    head->next = NULL;
    head->prev = NULL;
    
    struct Node* current = head;
    for (int i = 1; i < size; i++) {
        struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
        newNode->data = arr[i];
        newNode->next = NULL;
        newNode->prev = current;
        current->next = newNode;
        current = newNode;
    }
    return head;
}

void printDLL(struct Node* head) {
    if (head == NULL) {
        printf("NULL\n");
        return;
    }
    struct Node* current = head;
    while (current != NULL) {
        printf("%d", current->data);
        if (current->next != NULL) {
            printf(" <-> ");
        }
        current = current->next;
    }
    printf("\n");
}

void freeDLL(struct Node* head) {
    struct Node* temp;
    while (head != NULL) {
        temp = head;
        head = head->next;
        free(temp);
    }
}

int main() {
    int arr[] = {1, 2, 3, 4};
    int size = sizeof(arr) / sizeof(arr[0]);
    
    struct Node* head = createDLL(arr, size);
    
    printf("Original List: ");
    printDLL(head);
    
    head = deleteLastNode(head);
    
    printf("Updated List:  ");
    printDLL(head);
    
    freeDLL(head);
    return 0;
}