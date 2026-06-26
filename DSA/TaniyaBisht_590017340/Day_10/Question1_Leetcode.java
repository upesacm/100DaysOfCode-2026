
class Solution {
    public boolean compare(String haystack, String needle, int idx){
        int n=haystack.length();
        int m=needle.length();
        for(int i=0; i<m; i++){
            if(idx>=n){
                return false;
            }
            if(haystack.charAt(idx++) != needle.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        for(int i=0; i<n; i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(compare(haystack,needle,i)==true){
                    return i;
                }
            }
        }
        return -1;
    }
}