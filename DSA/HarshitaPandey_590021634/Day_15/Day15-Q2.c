/*
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;  };  */


#include <stdio.h>
#include <stdlib.h>

struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) 
{

    if (list1 == NULL)
    return list2;

    if (list2 == NULL)
    return list1;

    struct ListNode* temp1= list1;
    struct ListNode* temp2= list2;


    struct ListNode* dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode* tail = dummy;
    dummy->next = NULL;


    while (temp1 !=NULL && temp2 != NULL)
    {
        if (temp1->val <= temp2->val)
       {
          tail->next = temp1;
          temp1= temp1->next;
       }

        else if (temp2->val <= temp1->val)
       {
          tail->next = temp2;
          temp2 = temp2->next;
       }
       tail = tail->next;

    }


    if (temp1 != NULL)
    {
        tail->next = temp1;
    }


    if (temp2 != NULL)
    {
        tail->next = temp2;
    }
    return dummy->next;
    
}