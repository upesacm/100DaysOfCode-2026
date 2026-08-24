int findJudge(int n, int** trust, int trustSize, int* trustColSize) {
    int score[n];

    for (int i = 0; i < n; i++)
        score[i] = 0;

    for (int i = 0; i < trustSize; i++) {
        score[trust[i][0] - 1]--;
        score[trust[i][1] - 1]++;
    }

    for (int i = 0; i < n; i++) {
        if (score[i] == n - 1)
            return i + 1;
    }

    return -1;
}