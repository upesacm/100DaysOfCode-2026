public class Question1_Leetcode{
    public int lengthOfLastWord(String s) {
        int i=s.length()-1;
        while(i>=0 && s.charAt(i)==' '){i--;}
        int length=0;
        while(i>=0 && s.charAt(i)!=' '){
            length++;
            i--;        
        }       
    return length;        
    }
}