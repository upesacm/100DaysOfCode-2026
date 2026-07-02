struct ListNode* rotateRight(struct ListNode* head, int k) {
    if (head == NULL || head->next == NULL ||k==0) return head;

    struct ListNode* last = head;
    int count = 1;
    while (last->next) {
        count++;
        last = last->next;
    }

    k %= count;
    if (k==0) return head;

    k = count - k;
    last->next = head;

    while (k>0) {
        last = last->next;
        k--;
    }

    head = last->next;
    last->next = NULL;
    
    return head;
}