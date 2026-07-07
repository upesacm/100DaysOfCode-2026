#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

// Create node
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

// Remove elements
struct Node* removeElements(struct Node* head, int val) {

    struct Node dummy;
    dummy.data = 0;
    dummy.next = head;

    struct Node* curr = &dummy;

    while (curr->next != NULL) {

        if (curr->next->data == val) {

            struct Node* temp = curr->next;
            curr->next = temp->next;
            free(temp);

        } else {

            curr = curr->next;
        }
    }

    return dummy.next;
}

// Print list
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

    insertEnd(&head,1);
    insertEnd(&head,2);
    insertEnd(&head,6);
    insertEnd(&head,3);
    insertEnd(&head,4);
    insertEnd(&head,5);
    insertEnd(&head,6);

    printf("Original List:\n");
    printList(head);

    head = removeElements(head, 6);

    printf("After Removing 6:\n");
    printList(head);

    return 0;
}