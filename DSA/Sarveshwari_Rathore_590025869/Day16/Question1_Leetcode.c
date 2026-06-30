struct ListNode* swapPairs(struct ListNode* head) {
    if (head == NULL || head->next == NULL) {
        return head;
    }
    struct ListNode temp;
    temp.next = head;
    struct ListNode* prev = &temp;
    struct ListNode* curr = head;
    struct ListNode* Next = head -> next;
    while(curr != NULL && Next != NULL){
        curr->next = Next->next;
        Next -> next = curr;
        prev->next = Next;
        prev = curr;
        curr = curr -> next;
        if(curr!= NULL){
            Next = curr->next;
        }
    } return temp.next;
}