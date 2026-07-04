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

struct node* oddEven(struct node* head) {
  if(head==NULL || head->next==NULL) return head;
  struct node *eventail=NULL;
  struct node *oddtail=NULL;
  struct node *oddhead=NULL;
  struct node *evenhead=NULL;
  struct node *temp=head;
  while(temp!=NULL){
    struct node *nextnode=temp->next;
    temp->next=NULL;

    if(temp->data%2==0){
      if(evenhead==NULL)
      evenhead=eventail=temp;
      else{
        eventail->next=temp;
        eventail=temp;
      }
    }
    else{
      if(oddhead==NULL)
      oddhead=oddtail=temp;
      else{
        oddtail->next=temp;
        oddtail=temp;
      }
    }
    temp=nextnode;
  }
  if (evenhead==NULL) return oddhead;

  eventail->next=oddhead;
  return evenhead;
}

void printList(struct node* head){
  while(head!=NULL){
    printf("%d ",head->data);
    head=head->next;
  }
}

int main(){

  struct node* head=NULL;
  int value;
  char choice;

  do{
    printf("Enter value: ");
    scanf("%d",&value);
    head=insertEnd(head,value);
    printf("Add another node? (Y/N): ");
    scanf(" %c",&choice);

  }while(choice=='Y');

  head=oddEven(head);
  printList(head);

  return 0;
}
