#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

// Create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Insert node at the end
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

// Merge two sorted linked lists
struct Node* mergeTwoLists(struct Node* list1, struct Node* list2) {
    struct Node dummy;
    struct Node* tail = &dummy;

    dummy.next = NULL;

    while (list1 != NULL && list2 != NULL) {
        if (list1->data <= list2->data) {
            tail->next = list1;
            list1 = list1->next;
        } else {
            tail->next = list2;
            list2 = list2->next;
        }
        tail = tail->next;
    }

    if (list1 != NULL)
        tail->next = list1;
    else
        tail->next = list2;

    return dummy.next;
}

// Display linked list
void display(struct Node* head) {
    while (head != NULL) {
        printf("%d ", head->data);
        head = head->next;
    }
    printf("\n");
}

int main() {
    struct Node *list1 = NULL, *list2 = NULL;
    int n1, n2, value;

    printf("Enter number of elements in first sorted list: ");
    scanf("%d", &n1);

    printf("Enter elements:\n");
    for (int i = 0; i < n1; i++) {
        scanf("%d", &value);
        insertEnd(&list1, value);
    }

    printf("Enter number of elements in second sorted list: ");
    scanf("%d", &n2);

    printf("Enter elements:\n");
    for (int i = 0; i < n2; i++) {
        scanf("%d", &value);
        insertEnd(&list2, value);
    }

    struct Node* merged = mergeTwoLists(list1, list2);

    printf("Merged Sorted List: ");
    display(merged);

    return 0;
}