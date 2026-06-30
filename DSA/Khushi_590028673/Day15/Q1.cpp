// Q1-Merge Two Sorted Lists

#include <iostream>
#include <vector>
using namespace std;

// Definition for singly-linked list
struct ListNode {
    int val;
    ListNode* next;

    ListNode(int x) {
        val = x;
        next = nullptr;
    }
};

// Function to merge two sorted linked lists
ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
    ListNode dummy(0);
    ListNode* tail = &dummy;

    while (list1 != nullptr && list2 != nullptr) {
        if (list1->val <= list2->val) {
            tail->next = list1;
            list1 = list1->next;
        } else {
            tail->next = list2;
            list2 = list2->next;
        }
        tail = tail->next;
    }

    // Attach the remaining nodes
    if (list1 != nullptr)
        tail->next = list1;
    else
        tail->next = list2;

    return dummy.next;
}

// Function to create a linked list
ListNode* createList(int n) {
    if (n == 0)
        return nullptr;

    int value;
    cin >> value;
    ListNode* head = new ListNode(value);
    ListNode* tail = head;

    for (int i = 1; i < n; i++) {
        cin >> value;
        tail->next = new ListNode(value);
        tail = tail->next;
    }

    return head;
}

// Function to print the linked list
void printList(ListNode* head) {
    cout << "[";
    while (head != nullptr) {
        cout << head->val;
        if (head->next != nullptr)
            cout << ",";
        head = head->next;
    }
    cout << "]";
}

int main() {
    int n1, n2;

    // Input size of first list
    cout << "Enter number of elements in List 1: ";
    cin >> n1;
    cout << "Enter sorted elements of List 1: ";
    ListNode* list1 = createList(n1);

    // Input size of second list
    cout << "Enter number of elements in List 2: ";
    cin >> n2;
    cout << "Enter sorted elements of List 2: ";
    ListNode* list2 = createList(n2);

    // Merge lists
    ListNode* merged = mergeTwoLists(list1, list2);

    // Output
    cout << "Merged Sorted List: ";
    printList(merged);
    cout << endl;

    return 0;
}
