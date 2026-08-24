class Solution {

    public int findJudge(int n, int[][] trust) {

        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        for (int[] relation : trust) {

            int a = relation[0];
            int b = relation[1];

            outDegree[a]++;
            inDegree[b]++;
        }

        for (int person = 1; person <= n; person++) {

            if (inDegree[person] == n - 1 &&
                outDegree[person] == 0) {

                return person;
            }
        }

        return -1;
    }
}