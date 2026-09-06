public class Question1_Leetcode {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) return -1;       
        int[] score = new int[n + 1];       
        for (int[] t : trust) {
            score[t[0]]--;
            score[t[1]]++;
        }      
        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) return i;
        }
        return -1;
    }
}