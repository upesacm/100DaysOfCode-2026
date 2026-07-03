#include <iostream>
#include <vector>
using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == NULL) return NULL;

        ListNode* temp = head->next;
        ListNode* prev = head;

        while (temp) {
            if (temp->val == prev->val) {
                prev->next = temp->next;
                delete temp;           // Free memory
                temp = prev->next;
            } else {
                prev = temp;
                temp = temp->next;
            }
        }

        return head;
    }
};

// Function to create linked list
ListNode* createList(vector<int> arr) {
    if (arr.empty()) return nullptr;

    ListNode* head = new ListNode(arr[0]);
    ListNode* temp = head;

    for (int i = 1; i < arr.size(); i++) {
        temp->next = new ListNode(arr[i]);
        temp = temp->next;
    }

    return head;
}

// Function to print linked list
void printList(ListNode* head) {
    while (head) {
        cout << head->val;
        if (head->next)
            cout << " -> ";
        head = head->next;
    }
    cout << endl;
}

// Function to free memory
void deleteList(ListNode* head) {
    while (head) {
        ListNode* temp = head;
        head = head->next;
        delete temp;
    }
}

int main() {
    int n;

    cout << "Enter number of nodes: ";
    cin >> n;

    vector<int> arr(n);

    cout << "Enter " << n << " sorted elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    ListNode* head = createList(arr);

    cout << "Original List: ";
    printList(head);

    Solution obj;
    head = obj.deleteDuplicates(head);

    cout << "After Removing Duplicates: ";
    printList(head);

    deleteList(head);

    return 0;
}
