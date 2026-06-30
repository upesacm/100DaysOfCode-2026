#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node* createNode(int data) {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

struct Node* swapPairs(struct Node *head) {

    struct Node dummy;
    dummy.next = head;

    struct Node *prev = &dummy;

    while (prev->next != NULL && prev->next->next != NULL) {

        struct Node *first = prev->next;
        struct Node *second = first->next;

        // Swap the nodes
        first->next = second->next;
        second->next = first;
        prev->next = second;

        // Move to the next pair
        prev = first;
    }

    return dummy.next;
}

void printList(struct Node *head) {
    while (head != NULL) {
        printf("%d ", head->data);
        head = head->next;
    }
    printf("\n");
}

int main() {

    // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
    struct Node *head = createNode(1);
    head->next = createNode(2);
    head->next->next = createNode(3);
    head->next->next->next = createNode(4);
    head->next->next->next->next = createNode(5);

    printf("Original Linked List: ");
    printList(head);

    head = swapPairs(head);

    printf("After Swapping Pairs: ");
    printList(head);

    return 0;
}