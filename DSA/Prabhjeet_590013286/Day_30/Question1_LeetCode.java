/**
 * LeetCode 1047 - Remove All Adjacent Duplicates In String
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */

//Need to keep removing adjacent duplicates until none are left

import java.util.Stack;

class Solution {

    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // same character again, remove the pair
            if (!stack.isEmpty() && stack.peek() == ch) {

                stack.pop();

            } else {

                stack.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        // build the final string from the stack
        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}