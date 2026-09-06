// Leetcode Problem 997
// Find the Town Judge 

int findJudge(int n, int** trust, int trustSize, int* trustColSize) {
    int trustedBy[n + 1];
    int trusts[n + 1];
    for (int i = 0; i <= n; i++) {
        trustedBy[i] = 0;
        trusts[i] = 0;
    }
    for (int i = 0; i < trustSize; i++) {
        int a = trust[i][0];
        int b = trust[i][1];
        trusts[a]++;
        trustedBy[b]++;
    }
    for (int i = 1; i <= n; i++) {
        if (trustedBy[i] == n - 1 && trusts[i] == 0)
            return i;
    }
    return -1;
}