struct ListNode* swapPairs(struct ListNode* head) {
    if (head == NULL || head->next == NULL) return head;
    struct ListNode ans;
    ans.next = head;
    struct ListNode* prev = &ans;

    while (head && head->next) {
        struct ListNode* p1 = head;
        struct ListNode* p2 = head->next;
        prev->next = p2;
        p1->next = p2->next;
        p2->next = p1;
        prev = p1;
        head = p1->next;
    }
    return ans.next;
}