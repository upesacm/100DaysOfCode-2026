class Solution {
    public int findCenter(int[][] edges) {
        int[] e1=edges[0];
        int[] e2=edges[1];
        return(e1[0]==e2[0] || e1[0]==e2[1])
            ?e1[0]
            :e1[1];
        
    }
}