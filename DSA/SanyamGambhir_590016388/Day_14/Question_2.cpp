#include <iostream>

using namespace std;

// Definition for singly-linked list node (Boilerplate)
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* curr = head;
        ListNode* nextNode = nullptr;
        
        while (curr != nullptr) {
            nextNode = curr->next; // 1. Save the next node
            curr->next = prev;     // 2. Reverse the current node's pointer
            prev = curr;           // 3. Move 'prev' one step forward
            curr = nextNode;       // 4. Move 'curr' one step forward
        }
        
        // 'prev' will be pointing to the new head of the reversed list
        return prev;
    }
};

// Helper function to print the linked list
void printList(ListNode* head) {
    ListNode* temp = head;
    while (temp != nullptr) {
        cout << temp->val << " -> ";
        temp = temp->next;
    }
    cout << "NULL" << endl;
}

// Main function to test the code locally
int main() {
    // Creating a sample list: 1 -> 2 -> 3 -> 4 -> 5 -> NULL
    ListNode* head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = new ListNode(5);

    cout << "Original List: ";
    printList(head);

    Solution solution;
    ListNode* reversedHead = solution.reverseList(head);

    cout << "Reversed List: ";
    printList(reversedHead);

    // Clean up memory
    while (reversedHead != nullptr) {
        ListNode* temp = reversedHead;
        reversedHead = reversedHead->next;
        delete temp;
    }

    return 0;
}