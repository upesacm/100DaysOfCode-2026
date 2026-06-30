#include <iostream>
#include <vector>
using namespace std;

struct ListNode{
    int val;
    ListNode* next;

    ListNode():val(0), next(NULL) {}
    ListNode(int x):val(x), next(NULL){}
};

class Solution{
    public:
    ListNode* swapPairs(ListNode* head){
        ListNode dummy(0);
        dummy.next=head;

        ListNode* prev=&dummy;

        while(prev->next!=NULL && prev->next->next !=NULL){
            ListNode* first = prev->next;
            ListNode* second= first->next;

            first->next= second->next;
            second->next = first;
            prev->next=second;

            prev= first;
        }

        return dummy.next;
    }
};

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

// Print linked list
void printList(ListNode* head) {
    while (head != nullptr) {
        cout << head->val;
        if (head->next != nullptr)
            cout << " -> ";
        head = head->next;
    }
    cout << endl;
}
int main() {

    vector<int> arr = {1, 2, 3, 4, 5};

    ListNode* head = createList(arr);

    cout << "Original List: ";
    printList(head);

    Solution obj;
    head = obj.swapPairs(head);

    cout << "After Swapping: ";
    printList(head);

    return 0;
}