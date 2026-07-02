#include <stdio.h>
#include <stdlib.h>
struct node {
  int data;
  struct node* next;
};

struct node* createNode(int value){
  struct node*n=malloc(sizeof(struct node));
  n->data=value;
  n->next=NULL;
  return n;
}

struct node* insertEnd(struct node* head, int value){
  struct node* newNode=createNode(value);
  if(head==NULL) return newNode;

  struct node* temp=head;
  while(temp->next!=NULL){
    temp=temp->next;
  }
  temp->next=newNode;
  return head;
}

struct node* removeNthFromEnd(struct node* head, int n) {
    if(head==NULL) return NULL;
    struct node* temp=head;
    int count=0;
    while(temp!=NULL){
        count++;
        temp=temp->next;
    } 

    if(n==count){
        struct node* del1=head;
        head=head->next;
        free(del1);
        return head;
    }

    struct node* temp1=head;
    for(int i=1;i<count-n;i++) temp1=temp1->next;
    struct node* del=temp1->next;
    temp1->next=del->next;
    free(del);
    return head;
}
