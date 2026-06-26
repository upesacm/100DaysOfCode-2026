//Approach 1: Using naive approach
public class Question1_Leetcode{
    public int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){            
        if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
}
} 
// Approach 2: Using KMP (Knuth-Morris-Pratt)
public class Question1_Leetcode{                                      
    public int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        int[] pi = computePi(needle);
        int i=0;int j=0;
        while(i<haystack.length()){
            if(haystack.charAt(i)== needle.charAt(j)){
                i++;
                j++;
            }
        if(j==needle.length()){
            return i-j;
        }
        else if(i<haystack.length() && haystack.charAt(i)!= needle.charAt(j)){
            if(j!=0) j=pi[j-1];
            else i++;
        }
        }
    return -1;
    }
private int[] computePi(String s){
    int[] pi=new int[s.length()];
    int l=0;
    int i=1;
    while(i<s.length()){
        if(s.charAt(i)==s.charAt(l)){
            l++;
            pi[i]=l;
            i++;
        }
        else{
            if(l!=0){
                l=pi[l-1];
            }
            else{
                pi[i]=0;
                i++;
            }
        }
    }
    return pi;
}
}