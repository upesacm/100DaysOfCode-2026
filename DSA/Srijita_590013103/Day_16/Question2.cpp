class Solution {
public:
    Node* deleteLastNode(Node* head) {
        if (!head) return nullptr;
        if (!head->next) {
            delete head;
            return nullptr;
        }
        Node* curr = head;
        while (curr->next) {
            curr = curr->next;
        }
        curr->prev->next = nullptr;
        delete curr;
        return head;
    }
};