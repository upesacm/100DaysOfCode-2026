/* Length of Last Word
Explanation
Find the length of the last word in a string. */

class Solution {
    public int lengthOfLastWord(String s) {
        
        int len = 0;
        int flag = 0;
        int i;

        for(i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);

            if(ch != ' '){
                flag = 1;
                len++;
            }else if(flag == 1){
                break;
            }
        }
        return len;
    }
}