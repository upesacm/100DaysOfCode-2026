#include<stdio.h>
#include<stdlib.h>
struct node {              
    int data;
    struct node *next;         
};
struct node *createnode(int value) {
  struct node *n=malloc(sizeof(struct node));
  n->data=value;
  n->next=NULL;
  return n;
}

int reverse(struct node *head) {
if(head==NULL) return 0;
reverse(head->next);
printf("%d ", head->data);
printf("\n");

}
struct node *realrev(struct node *head) {
    struct node *current=head->next->next,*prev=head->next,*temp;
    while(current!=NULL) {
        temp=current->next;
        current->next=prev;
        prev=current;
        current=temp;
    }
    head=prev;
    return head;
    
}
void main() {
  struct node *head=NULL,*tail=NULL;
  int value,opr;
  char choice='y';

  do {
    printf("Enter data:");
    scanf("%d",&value);
    struct node *newnode=createnode(value);

    if(head==NULL) {
      head=newnode;
      tail=newnode;
    }
    else {
      tail->next=newnode;
      tail=newnode;
    }

    printf("Add another node??");
    scanf(" %c",&choice);

    if(choice!='y' && choice!='Y' && choice!='n' && choice!='N') {
      printf("INVALID CHOICE!!");
      choice='y';
    }
    
  } while(choice=='y' || choice=='Y');

  reverse(head);
  realrev(head);
  printf("%d ", head->data);
}
