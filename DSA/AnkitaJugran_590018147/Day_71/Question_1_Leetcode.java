class Solution {
    public int findJudge(int n, int[][] trust) {
        
        //array for person who are trusting someone
        //array size is n+1 because people are labeled from 1 to n but array indices start from 0
        int[] outgoing = new int[n + 1];

        //array of person who are trusted
        int[] incoming = new int[n + 1];


        for (int[] pair : trust) {
            int a = pair[0];
            int b = pair[1];

            //updating the value at indices
            outgoing[a]++;
            incoming[b]++;
        }

        for (int person = 1; person <= n; person++) {
            //if person outgoing is 0 means he is not trusting anyone & incoming is n-1 means he is
            //trusted by everyone except him then he is the town judge
            if (outgoing[person] == 0 && incoming[person] == n - 1) {
                return person;
            }
        }

        return -1;
    }
}