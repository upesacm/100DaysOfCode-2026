public class Question1_Leetcode {
    public boolean isIsomorphic(String s, String t) {
        int [] S= new int[128];
        int [] T= new int[128];
        for (int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(S[c1]!=T[c2]) return false;
            S[c1]=i+1;
            T[c2]=i+1;
        }
        return true;
    }
    
}