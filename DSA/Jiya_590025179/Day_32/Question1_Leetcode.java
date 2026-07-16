class Solution {
    public int minLength(String s) {
        String ans="";
        for (char ch:s.toCharArray()) {
            ans=ans+ch;
            while (ans.contains("AB")||ans.contains("CD")){
                ans=ans.replace("AB", ""); ans=ans.replace("CD", "");
            }
        }
        return ans.length();
    }
}
