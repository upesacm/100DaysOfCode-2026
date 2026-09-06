
class Solution {
    public int hammingDistance(int x, int y) {
        int r = x^y;
        int count=0;
        while(r>0){
            count += r & 1;
            r >>= 1;
        }
        return count;
    }
}