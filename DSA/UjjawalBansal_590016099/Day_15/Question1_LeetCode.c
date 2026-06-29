struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    // Edge Cases where either one or both lined list are NULL
    if (list1 == NULL && list2 == NULL) return NULL;
    if (list1 == NULL) return list2;
    if (list2 == NULL) return list1;

    // head pointer to point towards the least of the first elements of the two lists (Points towards list1 if both are equal)
    struct ListNode* head = NULL;
    if (list1->val <= list2->val) {
        head = list1;
        list1 = list1->next;
    }
    else {
        head = list2;
        list2 = list2->next;
    }

    struct ListNode* ans = head; // ans pointer to stay at the head of our final linked list

    // Merging the two list by comparing the value of their nodes
    while (list1 != NULL && list2 != NULL) {
        if (list1->val <= list2->val) {
            head->next = list1;
            list1 = list1->next;
        }
        else {
            head->next = list2;
            list2 = list2->next;
        }
        head = head->next;
    }

    // Joining the leftovers of the remaining linked list;
    if (list1 != NULL) head->next = list1;
    else head->next = list2;
    
    return ans;
}