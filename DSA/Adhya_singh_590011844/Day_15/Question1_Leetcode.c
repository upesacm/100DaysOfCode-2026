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

struct Node* mergeTwoLists(struct Node* list1, struct Node* list2) {
    if (list1 == NULL)
        return list2;
    if (list2 == NULL)
        return list1;

    if (list1->data <= list2->data) {
        list1->next = mergeTwoLists(list1->next, list2);
        return list1;
    } else {
        list2->next = mergeTwoLists(list1, list2->next);
        return list2;
    }
}

void printList(struct Node *head) {
    while (head != NULL) {
        printf("%d ", head->data);
        head = head->next;
    }
    printf("\n");
}

int main() {
    int n1, n2, value;
    struct Node *list1 = NULL, *list2 = NULL, *temp = NULL;

    printf("Enter number of nodes in first list: ");
    scanf("%d", &n1);

    printf("Enter elements of first sorted list:\n");
    for (int i = 0; i < n1; i++) {
        scanf("%d", &value);
        struct Node *newNode = createNode(value);

        if (list1 == NULL) {
            list1 = newNode;
            temp = list1;
        } else {
            temp->next = newNode;
            temp = newNode;
        }
    }

    printf("Enter number of nodes in second list: ");
    scanf("%d", &n2);

    temp = NULL;

    printf("Enter elements of second sorted list:\n");
    for (int i = 0; i < n2; i++) {
        scanf("%d", &value);
        struct Node *newNode = createNode(value);

        if (list2 == NULL) {
            list2 = newNode;
            temp = list2;
        } else {
            temp->next = newNode;
            temp = newNode;
        }
    }

    struct Node *merged = mergeTwoLists(list1, list2);

    printf("Merged Sorted List: ");
    printList(merged);

    return 0;
}