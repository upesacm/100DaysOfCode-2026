import java.util.*;
class Question2 {
    public static int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            outDegree[a]++;
            inDegree[b]++;
        }
        for (int i = 1; i <= n; i++) {
            if (outDegree[i] == 0 && inDegree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] trust = {
            {1, 3},
            {2, 3},
            {4, 3},
            {5, 3},
            {1, 2}
        };
        System.out.println(findJudge(n, trust));
    }
}