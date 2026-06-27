class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        int nl=1;
        int w=0;
        for(char c:s.toCharArray()){
            int cw=widths[c-'a'];
            if(cw+w>100){
                nl++;
                w=cw;
            }else{
                w+=cw;
            }
            
        }
        result[0]=nl;
        result[1]=w;
        return result;
    }
}