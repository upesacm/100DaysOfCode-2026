class Solution {
    public int findCenter(int[][] edges) {

        int n = edges.length;

        int[] freq = new int[n + 2];

        for( int[] pair : edges ){
            freq[pair[0]]++;
            freq[pair[1]]++;
        }

        for( int i = 1 ; i <= n + 1 ; i++ ){
            if( freq[i] == n ){
                return i;
            }
        }
        return -1;
    }
}