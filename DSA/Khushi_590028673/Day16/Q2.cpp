#include <iostream>
#include <vector>
using namespace std;

struct Node{
    int data;
    Node* prev;
    Node* next;

    Node(int val){
        data= val;
        prev= NULL;
        next = NULL;
    }
};


Node* createList(vector <int>arr){
    if(arr.empty())return NULL;

    Node*head = new Node(arr[0]);
    Node*temp = head;

    for(int i=1; i<arr.size(); i++){
        Node* newNode= new Node(arr[i]);
        temp->next = newNode;
        newNode->prev=temp;
        temp=newNode;
    }
    return head;
}

void printList(Node* head){
    if(head==NULL){
        cout<<"NULL";
        return;
    }
    while (head != nullptr) {
        cout << head->data;
        if (head->next != nullptr)
            cout << " <-> ";
        head = head->next;
    }
    cout << endl;
}

Node* deleteLastNode(Node* head) {

    // Empty list
    if (head == nullptr)
        return nullptr;

    // Only one node
    if (head->next == nullptr) {
        delete head;
        return nullptr;
    }

    // Traverse to last node
    Node* temp = head;
    while (temp->next != nullptr) {
        temp = temp->next;
    }

    // Disconnect last node
    temp->prev->next = nullptr;

    // Delete last node
    delete temp;

    return head;
}

int main() {

    vector<int> arr = {1, 2, 3, 4};

    Node* head = createList(arr);

    cout << "Original List:\n";
    printList(head);

    head = deleteLastNode(head);

    cout << "After Deleting Last Node:\n";
    printList(head);

    return 0;
}