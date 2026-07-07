#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

// Create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Insert at end
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

// Rearrange even nodes before odd nodes
struct Node* rearrangeEvenOdd(struct Node* head) {

    if (head == NULL)
        return NULL;

    struct Node *evenStart = NULL, *evenEnd = NULL;
    struct Node *oddStart = NULL, *oddEnd = NULL;

    struct Node* curr = head;

    while (curr != NULL) {

        struct Node* nextNode = curr->next;
        curr->next = NULL;

        if (curr->data % 2 == 0) {

            if (evenStart == NULL) {
                evenStart = evenEnd = curr;
            } else {
                evenEnd->next = curr;
                evenEnd = curr;
            }

        } else {

            if (oddStart == NULL) {
                oddStart = oddEnd = curr;
            } else {
                oddEnd->next = curr;
                oddEnd = curr;
            }
        }

        curr = nextNode;
    }

    if (evenStart == NULL)
        return oddStart;

    if (oddStart == NULL)
        return evenStart;

    evenEnd->next = oddStart;

    return evenStart;
}

// Print linked list
void printList(struct Node* head) {

    while (head != NULL) {
        printf("%d", head->data);

        if (head->next != NULL)
            printf(" -> ");

        head = head->next;
    }

    printf("\n");
}

int main() {

    struct Node* head = NULL;

    insertEnd(&head, 1);
    insertEnd(&head, 2);
    insertEnd(&head, 3);
    insertEnd(&head, 4);
    insertEnd(&head, 5);
    insertEnd(&head, 6);
    insertEnd(&head, 7);

    printf("Original List:\n");
    printList(head);

    head = rearrangeEvenOdd(head);

    printf("After Rearranging:\n");
    printList(head);

    return 0;
}