#include <stdio.h>
#include <stdlib.h>
struct Node{
    int data;
    struct Node* next;
};
struct Node* segregate(struct Node* head){
    struct Node *evenstart=NULL,*evenend=NULL;
    struct Node *oddstart=NULL,*oddend=NULL;
    struct Node* curr=head;
    while(curr){
        if(curr->data%2==0){
            if(!evenstart){
                evenstart=evenend=curr;
            } 
            else{
                evenend->next=curr;
                evenend =curr;
            }
        }else{
            if(!oddstart) {
                oddstart=oddend=curr;
            }else{
                oddend->next=curr;
                oddend=curr;
            }
        }
        curr=curr->next;
    }
    if(!evenstart||!oddstart)
        return head;
    evenend->next=oddstart;
    oddend->next=NULL;
    return evenstart;
}

void display(struct Node* head) {
    while(head){
        printf("%d ", head->data);
        head=head->next;
    }
}

int main(){
    int n, x;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    struct Node *head=NULL, *temp=NULL, *newNode;
    for(int i=0;i<n;i++){
        printf("Enter the number:");
        scanf("%d", &x);
        newNode=(struct Node*)malloc(sizeof(struct Node));
        newNode->data=x;
        newNode->next=NULL;
        if(!head){
            head=newNode;
            temp=newNode;
        }else{
            temp->next=newNode;
            temp=newNode;
        }
    }
    head=segregate(head);
    printf("Modified list:\n");
    display(head);
    return 0;
}
