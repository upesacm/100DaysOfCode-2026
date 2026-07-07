#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

void insertEnd(struct Node** head, int data) {
    struct Node* newNode = createNode(data);

    if (*head == NULL) {
        *head = newNode;
        return;
    }

    struct Node* temp = *head;
    while (temp->next != NULL)
        temp = temp->next;

    temp->next = newNode;
}

struct Node* swapPairs(struct Node* head) {
    if (head == NULL || head->next == NULL)
        return head;

    struct Node dummy;
    dummy.next = head;

    struct Node* prev = &dummy;

    while (prev->next != NULL && prev->next->next != NULL) {

        struct Node* first = prev->next;
        struct Node* second = first->next;

        first->next = second->next;
        second->next = first;
        prev->next = second;

        prev = first;
    }

    return dummy.next;
}

void printList(struct Node* head) {
    while (head != NULL) {
        printf("%d ", head->data);
        head = head->next;
    }
    printf("\n");
}

int main() {

    struct Node* head = NULL;

    insertEnd(&head,1);
    insertEnd(&head,2);
    insertEnd(&head,3);
    insertEnd(&head,4);

    printf("Original List:\n");
    printList(head);

    head = swapPairs(head);

    printf("After Swapping:\n");
    printList(head);

    return 0;
}