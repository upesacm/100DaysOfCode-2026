#include <bits/stdc++.h>
using namespace std;

// this is the question from leetcode (206)
/** 
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        stack <int> st;
        ListNode* temp = head;
        while(temp != NULL){
            st.push(temp->val);
            temp = temp->next;
        }
        ListNode* ele = head;
        while(ele != NULL ){
            ele->val = st.top();
            st.pop();
            ele = ele->next;
        }
        return head;
    }
};