//Need to satisfy the maximum number of children with available cookies

import java.util.Arrays;

class Solution {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        // try giving the smallest possible cookie first
        while (child < g.length && cookie < s.length) {

            if (s[cookie] >= g[child]) {

                child++;
            }

            cookie++;
        }

        return child;
    }
}