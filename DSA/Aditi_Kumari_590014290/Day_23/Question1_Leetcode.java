public class Question1_Leetcode {
    public int findContentChildren(int[] g, int[] s) {
        int child=0;
        int cookie=0;
        int count =0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(child < g.length && cookie < s.length){
            if(g[child] > s[cookie]){
                cookie++;
            }
            else{
                cookie++;
                child++;
                count++;
            }
        }
        return count;
    }
}