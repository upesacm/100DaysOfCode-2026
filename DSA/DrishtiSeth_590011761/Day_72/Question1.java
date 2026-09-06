class Solution {
    public int findCenter(int[][] edges) {
        
        // If first edge and second edge have a common node,
        // that node is the center.
        
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        
        return edges[0][1];
    }
}
