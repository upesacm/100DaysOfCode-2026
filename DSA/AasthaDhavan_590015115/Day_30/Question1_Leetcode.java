class Solution {
    public String removeDuplicates(String s) {
        StringBuilder st=new StringBuilder();
        for (Character c: s.toCharArray()){
            if(st.length()>0 && st.charAt(st.length()-1)==c){
                st.deleteCharAt(st.length()-1);
            }
            else{
                st.append(c);
            }
        }
        return st.toString();
    }
}