#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *prev;
    struct Node *next;
};

struct Node* createNode(int data) {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->prev = NULL;
    newNode->next = NULL;
    return newNode;
}

struct Node* deleteLastNode(struct Node *head) {

    if (head == NULL)
        return NULL;
    if (head->next == NULL) {
        free(head);
        return NULL;
    }

    struct Node *temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->prev->next = NULL;
    free(temp);

    return head;
}

void printList(struct Node *head) {

    if (head == NULL) {
        printf("NULL\n");
        return;
    }

    while (head != NULL) {
        printf("%d ", head->data);
        head = head->next;
    }

    printf("\n");
}

int main() {
    struct Node *head = createNode(10);

    head->next = createNode(20);
    head->next->prev = head;

    head->next->next = createNode(30);
    head->next->next->prev = head->next;

    head->next->next->next = createNode(40);
    head->next->next->next->prev = head->next->next;

    printf("Original Doubly Linked List: ");
    printList(head);

    head = deleteLastNode(head);

    printf("After Deleting Last Node: ");
    printList(head);

    return 0;
}