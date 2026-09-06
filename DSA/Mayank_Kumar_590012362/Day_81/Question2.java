class Solution {
    public int singleNumber(int[] a) {
        int o = 0, t = 0;
        for (int x : a) {
            o = (o ^ x) & ~t;
            t = (t ^ x) & ~o;
        } return o;
    }
}