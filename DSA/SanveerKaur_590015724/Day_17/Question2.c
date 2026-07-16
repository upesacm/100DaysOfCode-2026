# include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
typedef struct Node{
    int data;
    struct Node* next;
    } Node;
    Node* head= NULL;
    Node* tail= NULL;
    Node* createNode( int val){
        Node* newNode= (Node*)malloc(sizeof(Node));
        newNode-> data= val;
        newNode-> next= NULL;
        return newNode;
    }
 bool hasCycle(Node* head){
    Node* slow= head;
    Node* fast= head;
    while(fast!=NULL&& fast->next!= NULL){
        slow=slow->next;
        fast= fast->next->next;
        if(slow==fast)
        return true;
    }
    return false;
 }