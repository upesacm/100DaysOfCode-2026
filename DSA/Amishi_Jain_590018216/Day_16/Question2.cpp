//Reverse the singly linked list without create a new linked list

#include <iostream>
using namespace std;

// Node of Linked List
class Node {
public:
    int data;
    Node* next;

    Node(int val) {
        data = val;
        next = NULL;
    }
};

// Insert node at the end
void insert(Node* &head, int val) {

    Node* newNode = new Node(val);

    if(head == NULL) {
        head = newNode;
        return;
    }

    Node* temp = head;

    while(temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
}

// Print linked list
void display(Node* head) {

    while(head != NULL) {
        cout << head->data;

        if(head->next != NULL)
            cout << " -> ";

        head = head->next;
    }

    cout << endl;
}

// Reverse linked list
Node* reverseList(Node* head) {

    Node* prev = NULL;
    Node* curr = head;
    Node* nextNode = NULL;

    while(curr != NULL) {

        nextNode = curr->next;   // Store next node

        curr->next = prev;       // Reverse link

        prev = curr;             // Move prev ahead

        curr = nextNode;         // Move current ahead
    }

    return prev;
}

int main() {

    Node* head = NULL;

    int n;

    cout << "Enter number of nodes: ";
    cin >> n;

    cout << "Enter node values: ";

    for(int i = 0; i < n; i++) {

        int x;
        cin >> x;

        insert(head, x);
    }

    cout << "\nOriginal Linked List:\n";
    display(head);

    head = reverseList(head);

    cout << "\nReversed Linked List:\n";
    display(head);

    return 0;
}