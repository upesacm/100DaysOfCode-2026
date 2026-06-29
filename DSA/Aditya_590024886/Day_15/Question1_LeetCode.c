/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

 struct ListNode* createnode(int value){
    struct ListNode* n=malloc(sizeof(struct ListNode));
    n->val=value;
    n->next=NULL;
    return n;
 }
struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    struct ListNode* temp1=list1;
    struct ListNode* temp2=list2;
    struct ListNode* dummy=createnode(0);
    struct ListNode* curr=dummy;
    while(temp1!=NULL && temp2!=NULL){
        if(temp1->val<=temp2->val){
            curr->next=createnode(temp1->val);
            temp1=temp1->next;
        }
       else{
        curr->next=createnode(temp2->val);
        temp2=temp2->next;
       } 
       curr=curr->next;
    }
    while(temp1!=NULL){
        curr->next=createnode(temp1->val);
        curr=curr->next;
        temp1=temp1->next;
    }
    while(temp2!=NULL){
        curr->next=createnode(temp2->val);
        curr=curr->next;
        temp2=temp2->next;
    }

    return dummy->next;
}
