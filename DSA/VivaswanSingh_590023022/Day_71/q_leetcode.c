int findJudge(int n, int** trust, int trustSize, int* trustColSize)
{
    int score[1001] = {0};

    for (int i = 0; i < trustSize; i++)
    {
        score[trust[i][0]]--;
        score[trust[i][1]]++;
    }

    for (int i = 1; i <= n; i++)
    {
        if (score[i] == n - 1)
            return i;
    }

    return -1;
}