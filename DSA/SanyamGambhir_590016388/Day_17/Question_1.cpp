/**
 * Definition for singly-linked list.
 * struct ListNode {
 * int val;
 * ListNode *next;
 * ListNode() : val(0), next(nullptr) {}
 * ListNode(int x) : val(x), next(nullptr) {}
 * ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        // 1. Handle edge cases: empty list, single node, or no rotation
        if (!head || !head->next || k == 0) {
            return head;
        }
        
        // 2. Compute the length of the list and find the tail node
        ListNode* last = head;
        int length = 1;
        while (last->next) {
            last = last->next;
            length++;
        }
        
        // 3. Normalize k to avoid redundant full rotations
        k = k % length;
        if (k == 0) {
            return head;
        }
        
        // 4. Connect the tail to the head to make it circular
        last->next = head;
        
        // 5. Find the new tail: located (length - k - 1) steps from the head
        int stepsToNewTail = length - k - 1;
        ListNode* newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail->next;
        }
        
        // 6. Establish the new head and break the circular bond
        ListNode* newHead = newTail->next;
        newTail->next = nullptr;
        
        return newHead;
    }
};