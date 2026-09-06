class Solution {
    public int hammingDistance(int x, int y) {
        int xor=x^y;
        int ans=0;
        for(int i=0;i<32;i++){
            if(((xor>>i) & 1)==1){
                ans++;
            }
        }
        return ans;
    }
}