#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>
 
 struct ListNode {
 int val;
 struct ListNode *next;
 };
 struct ListNode* reverse(struct ListNode* head){// reversing the linkedlist
    struct ListNode* prev=NULL;
    struct ListNode* next=NULL;
    struct ListNode* curr=head;
    while(curr!=NULL){
        next= curr->next;
        curr->next=prev;
        prev= curr;
        curr=next;

    }
    return prev;
}
bool isPalindrome(struct ListNode* head) {// finding the middle element
   struct ListNode* slow= head;
   if (head==NULL|| head-> next== NULL)
   return true;
   struct ListNode* fast= head;
    while(fast->next!=NULL&& fast->next->next!=NULL){
        slow=slow->next;
        fast=fast->next->next;
        }
    struct ListNode* second=reverse(slow-> next);// reversing the second half of the linkedlist
   struct ListNode* first= head;//comparing the first and second half of the list
    struct ListNode* temp= second;
    while(temp!=NULL){
        if(first->val!= temp-> val)
        return false;
        first=first->next;
        temp=temp-> next;
    }
    return true;

}
