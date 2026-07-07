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

struct Node* deleteDuplicates(struct Node* head) {

    struct Node* curr = head;

    while (curr != NULL && curr->next != NULL) {

        if (curr->data == curr->next->data) {

            struct Node* temp = curr->next;
            curr->next = curr->next->next;
            free(temp);

        } else {

            curr = curr->next;
        }
    }

    return head;
}

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
    insertEnd(&head,1);
    insertEnd(&head,2);
    insertEnd(&head,3);
    insertEnd(&head,3);

    printf("Original List:\n");
    printList(head);

    head = deleteDuplicates(head);

    printf("After Removing Duplicates:\n");
    printList(head);

    return 0;
}