#include <stdio.h>
#include <stdlib.h>
struct Node{
    int data;
    struct Node* next;
};

struct Node* reverse(struct Node* head){
    struct Node *prev=NULL, *curr=head, *next=NULL;
    while(curr!=NULL){
        next=curr->next;
        curr->next=prev;
        prev=curr;
        curr=next;
    }
    return prev;
}
void printList(struct Node* head){
    while(head!=NULL){
        printf("%d ", head->data);
        head=head->next;
    }
}
int main(){
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    struct Node *head=NULL,*temp=NULL,*newNode;
    for(int i=0;i<n;i++){
        newNode=(struct Node*)malloc(sizeof(struct Node));
        scanf("%d", &newNode->data);
        newNode->next=NULL;
        if(head==NULL){
            head=newNode;
            temp=newNode;
        }
        else{
            temp->next=newNode;
            temp=newNode;
        }
    }
    head=reverse(head);
    printf("Reversed list:\n");
    printList(head);
    return 0;
}
