class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int i = 0,line = 1;
        int pix = 0;
        for(char ch : s.toCharArray()){
            if(pix + widths[ch - 'a'] <= 100){
                pix += widths[ch - 'a'];
            }else{
                line ++;
                pix = widths[ch - 'a'];
            }
            i++;
        }
        return new int[]{line,pix};
    }
}