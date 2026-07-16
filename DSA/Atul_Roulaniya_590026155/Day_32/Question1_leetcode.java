class Solution {
    public int minLength(String s) 
    {
        StringBuilder stack = new StringBuilder();
        for(char ch: s.toCharArray())
        {
            int n=stack.length();

            if(n >0 && ((stack.charAt(n-1) == 'A' && ch == 'B') || (stack.charAt(n-1) == 'C' && ch =='D')))
            {
                stack.deleteCharAt(n-1);
            }
            else
            {
                stack.append(ch);
            }
        }
        return stack.length();
        
    }
}