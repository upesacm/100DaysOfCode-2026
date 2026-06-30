/* Node structure
struct Node {
    int data;
    Node* next;
    Node* prev;

    Node(int x) {
        data = x;
        next = NULL;
        prev = NULL;
    }
};
*/

class Solution {
public:
    Node* deleteLastNode(Node* head) {
        // Case 1: Empty list
        if (head == NULL)
            return NULL;

        // Case 2: Only one node
        if (head->next == NULL) {
            delete head;
            return NULL;
        }

        // Traverse to the last node
        Node* temp = head;
        while (temp->next != NULL) {
            temp = temp->next;
        }

        // Remove the last node
        temp->prev->next = NULL;
        delete temp;

        return head;
    }
};
