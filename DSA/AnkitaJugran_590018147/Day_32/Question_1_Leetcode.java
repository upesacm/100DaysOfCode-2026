class Solution {
    public int minLength(String s) {
        
        Stack<Character> stack = new Stack<>();

        for( int i = 0 ; i < s.length() ; i++ ){

            char current = s.charAt(i);

            if( !stack.isEmpty() && (( stack.peek() == 'A' && current == 'B' ) || ( stack.peek() == 'C' && current == 'D')) ){
                stack.pop();
            }
            else{
                stack.push(current);
            }
        }

        return stack.size();
    }
}