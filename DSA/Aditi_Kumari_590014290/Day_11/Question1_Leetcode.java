package Day_11;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] arrS= new int[256];
        int[] arrT=new int[256];
        for (int i=0; i< s.length(); i++){
            char ch1= s.charAt(i);
            char ch2=t.charAt(i);
        if (arrS[ch1]!= arrT[ch2]){
            return false;
        }
        arrS[ch1]=i+1;
        arrT[ch2]=i+1;
        }
        return true;
    }
}