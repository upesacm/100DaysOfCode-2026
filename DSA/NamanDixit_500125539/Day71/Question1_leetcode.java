class Question1_leetcode {

    public int findJudge(int n, int[][] trust) {

        int[] score = new int[n + 1];

        for (int[] relation : trust) {
            int truster = relation[0];
            int trustee = relation[1];

            score[truster]--;
            score[trustee]++;
        }

        for (int person = 1; person <= n; person++) {
            if (score[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }
}