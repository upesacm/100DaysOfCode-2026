
class Solution {
    public int findCenter(int[][] edges) {
        int pair1[] =edges[0];
        int pair2[] =edges[1];
        if(pair1[0]==pair2[0] || pair1[0]==pair2[1]){
            return pair1[0];
        }
        return pair1[1];
    }
}