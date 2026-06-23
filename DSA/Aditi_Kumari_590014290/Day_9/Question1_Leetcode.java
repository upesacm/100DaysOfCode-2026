package Day_9;

class Solution {
    public int lengthOfLastWord(String s) {
        int sublen=0; 
        int len= s.length();
        int i= len-1;
        while (i>=0 && s.charAt(i) == ' '){
            i-=1;
        }
        while (i>=0 && s.charAt(i) != ' '){
            sublen+=1;
            i-=1;
        }
        return sublen;
    }
}