#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    struct ListNode dummy;
    struct ListNode* current = &dummy;
    dummy.next = NULL;
    
    while (list1 != NULL && list2 != NULL) {
        if (list1->val <= list2->val) {
            current->next = list1;
            list1 = list1->next;
        } else {
            current->next = list2;
            list2 = list2->next;
        }
        current = current->next;
    }
    
    if (list1 != NULL) {
        current->next = list1;
    } else {
        current->next = list2;
    }
    
    return dummy.next;
}

struct ListNode* createList(int* arr, int size) {
    if (size == 0) return NULL;
    struct ListNode* head = (struct ListNode*)malloc(sizeof(struct ListNode));
    head->val = arr[0];
    head->next = NULL;
    struct ListNode* current = head;
    for (int i = 1; i < size; i++) {
        current->next = (struct ListNode*)malloc(sizeof(struct ListNode));
        current = current->next;
        current->val = arr[i];
        current->next = NULL;
    }
    return head;
}

void printList(struct ListNode* head) {
    while (head != NULL) {
        printf("%d -> ", head->val);
        head = head->next;
    }
    printf("NULL\n");
}

void freeList(struct ListNode* head) {
    struct ListNode* temp;
    while (head != NULL) {
        temp = head;
        head = head->next;
        free(temp);
    }
}

int main() {
    int arr1[] = {1, 2, 4};
    int arr2[] = {1, 3, 4};
    
    struct ListNode* list1 = createList(arr1, 3);
    struct ListNode* list2 = createList(arr2, 3);
    
    printf("List 1: ");
    printList(list1);
    printf("List 2: ");
    printList(list2);
    
    struct ListNode* mergedList = mergeTwoLists(list1, list2);
    
    printf("Merged List: ");
    printList(mergedList);
    
    freeList(mergedList);
    
    return 0;
}