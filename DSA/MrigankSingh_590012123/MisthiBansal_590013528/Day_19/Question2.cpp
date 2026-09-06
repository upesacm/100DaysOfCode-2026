/* Given the head of a singly linked list, return the middle node of the linked list. If 
there are two middle nodes, return the second middle node. */
#include <bits/stdc++.h>
 using namespace std;

class Node{
public:
    int val;
    Node* next;  //pointer pointing to Node
        
    Node(int value){
        val = value;
        next = nullptr;
}
};

Node* createll(vector<int> &vec){
    if(vec.empty()){
        return nullptr;
    }
    Node* head = new Node(vec[0]); 
    Node* temp = head;

    for(int i = 1; i<vec.size(); i++){
        temp->next= new Node(vec[i]);
        temp=temp->next;
    }
    return head;
}

Node* midnode(Node* head){  //function to find the middle node
Node* slow = head;
Node* fast = head;

while(fast!= nullptr && fast->next != nullptr){
     slow = slow->next; //moves node by node
     fast = fast->next->next; //moves leaving one node at a time
}   
 return slow;
}
 
int main(){
    vector<int> vec = {1,2,3,4,5,6,7,8};

    Node* head = createll(vec);

    Node* mid = midnode(head);

    cout<<"Element at middle node:" << mid->val << endl;
    return 0;
}