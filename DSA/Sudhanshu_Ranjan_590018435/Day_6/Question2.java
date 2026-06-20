package DSA.Sudhanshu_Ranjan_590018435.Day_6;

import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<>(a.length + b.length);
        int i = 0, j = 0;
        Integer last = null;

        while (i < a.length && j < b.length) {
            int val;
            if (a[i] < b[j]) {
                val = a[i++];
            } else if (b[j] < a[i]) {
                val = b[j++];
            } else {
                val = a[i];
                i++;
                j++;
            }
            if (last == null || last != val) {
                ans.add(val);
                last = val;
            }
        }

        while (i < a.length) {
            int val = a[i++];
            if (last == null || last != val) {
                ans.add(val);
                last = val;
            }
        }

        while (j < b.length) {
            int val = b[j++];
            if (last == null || last != val) {
                ans.add(val);
                last = val;
            }
        }

        return ans;
    }
}