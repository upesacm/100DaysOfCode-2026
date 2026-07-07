import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // greed factors
        Arrays.sort(s); // cookie sizes

        int childPtr = 0; // points to current child in g
        int cookiePtr = 0; // points to current cookie in s
        int contentCount = 0;

        while (childPtr < g.length && cookiePtr < s.length) {
            if (s[cookiePtr] >= g[childPtr]) {
                // this cookie satisfies this child
                contentCount++;
                childPtr++;
                cookiePtr++;
            } else {
                // cookie too small, try the next bigger cookie
                cookiePtr++;
            }
        }

        return contentCount;
    }
}
