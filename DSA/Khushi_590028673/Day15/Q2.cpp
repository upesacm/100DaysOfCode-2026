// Q2-Reverse LL

#include <iostream>
using namespace std;

struct Node{
    int data;
    Node* next;

    Node(int val){
        data =val;
        next = NULL;
    }
};


Node* createList(int n){
    if(n==0) return NULL;

    int value;
    cin>>value;
    Node* head=new Node(value);
    Node* tail=head;

    for(int i=1;i<n; i++){
        cin>>value;
        tail->next=new Node(value);
        tail=tail->next;
    }

    return head;
}

Node* reverseList(Node* head) {
    Node* prev = nullptr;
    Node* curr = head;
    Node* next = nullptr;

    while (curr != nullptr) {
        next = curr->next;   // Save next node
        curr->next = prev;   // Reverse the link
        prev = curr;         // Move prev forward
        curr = next;         // Move curr forward
    }

    return prev;
}

// Function to print the linked list
void printList(Node* head) {
    while (head != nullptr) {
        cout << head->data;
        if (head->next != nullptr)
            cout << " -> ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    int n;

    cout << "Enter number of nodes: ";
    cin >> n;

    cout << "Enter the elements: ";
    Node* head = createList(n);

    cout << "Original Linked List: ";
    printList(head);

    head = reverseList(head);

    cout << "Reversed Linked List: ";
    printList(head);

    return 0;
}