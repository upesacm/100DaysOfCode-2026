#include <iostream>
#include <vector>

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // 1. Create a dummy node to handle edge cases cleanly (e.g., removing the head)
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        
        ListNode* fast = dummy;
        ListNode* slow = dummy;
        
        // 2. Advance the fast pointer so that there is a gap of exactly n nodes between fast and slow
        for (int i = 0; i <= n; ++i) {
            if (fast == nullptr) return head; // Safety check for out-of-bounds n
            fast = fast->next;
        }
        
        // 3. Move both pointers together until fast reaches the end of the list
        while (fast != nullptr) {
            fast = fast->next;
            slow = slow->next;
        }
        
        // 4. slow->next is the target node to delete. Save its reference to free the memory.
        ListNode* nodeToDelete = slow->next;
        slow->next = slow->next->next;
        
        delete nodeToDelete; // Prevent memory leaks
        
        // 5. Extract the actual updated head and clean up the dummy node
        ListNode* newHead = dummy->next;
        delete dummy; 
        
        return newHead;
    }
};

// --- Helper Functions to Test the Code ---

void printList(ListNode* head) {
    std::cout << "[";
    while (head != nullptr) {
        std::cout << head->val;
        if (head->next != nullptr) std::cout << ",";
        head = head->next;
    }
    std::cout << "]\n";
}

ListNode* createList(const std::vector<int>& values) {
    if (values.empty()) return nullptr;
    ListNode* head = new ListNode(values[0]);
    ListNode* curr = head;
    for (size_t i = 1; i < values.size(); ++i) {
        curr->next = new ListNode(values[i]);
        curr = curr->next;
    }
    return head;
}

int main() {
    Solution solution;
    
    // Example: head = [1, 2, 3, 4, 5], n = 2
    ListNode* head = createList({1, 2, 3, 4, 5});
    
    std::cout << "Original List: ";
    printList(head);
    
    head = solution.removeNthFromEnd(head, 2);
    
    std::cout << "Updated List (Removed 2nd from end): ";
    printList(head);
    
    // Memory cleanup for the remaining list
    while (head != nullptr) {
        ListNode* temp = head;
        head = head->next;
        delete temp;
    }
    
    return 0;
}