class Solution {
    public int minLength(String s) {
        Stack <Character> stack = new Stack <> ();
        for (int i = 0 ; i < s.length() ; i++ ) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            }
            else {
                if (stack.peek() == 'A' && s.charAt(i)=='B') {
                    stack.pop();
                }
                else if (stack.peek() == 'C' && s.charAt(i) == 'D'){
                    stack.pop();
                }
                else {
                    stack.push(s.charAt(i));
                }
            }

        }
        return stack.size();
        
    }
}