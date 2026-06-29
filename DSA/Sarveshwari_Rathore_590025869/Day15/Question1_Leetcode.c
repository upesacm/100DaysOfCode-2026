struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2){
    struct ListNode temph ;
    temph.next = NULL;
    struct ListNode* tail = &temph;
    while(list1 != NULL && list2 != NULL){
        if(list1 -> val <= list2 -> val){
            tail -> next = list1;
            list1 = list1 -> next;
        } else {
            tail -> next = list2;
            list2 = list2 -> next;
        } tail = tail -> next; 
    }
    if(list1 != NULL){
        tail -> next = list1;
    } else{
        tail -> next = list2;
    }
     return temph.next;
}