#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int value) {
        data = value;
        next = NULL;
    }
};

Node* reverseList(Node* head) {
    Node* previous = NULL;
    Node* current = head;
    Node* nextNode = NULL;
    while (current != NULL) {
        nextNode = current->next;
        current->next = previous;
        previous = current;
        current = nextNode;
    }
    return previous;
}

void printList(Node* head) {
    while (head != NULL) {
        cout << head->data;
        if (head->next != NULL)
            cout << " -> ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    Node* head = new Node(1);
    head->next = new Node(2);
    head->next->next = new Node(3);
    head->next->next->next = new Node(4);
    head->next->next->next->next = new Node(5);
    cout << "Original List: ";
    printList(head);

    head = reverseList(head);
    cout << "Reversed List: ";
    printList(head);
    return 0;
}
