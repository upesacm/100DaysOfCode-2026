class Solution {
    public String removeDuplicates(String s) {
        Stack <Character > stack = new Stack <> ();
        for (int i = 0 ; i < s.length() ; i++ ) {
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else if (stack.peek()!=s.charAt(i)){
                stack.push(s.charAt(i));
            }
            else if (stack.peek()==s.charAt(i)){
                stack.pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if (stack.size()==0) {
            return sb.toString();
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
         
    }
}