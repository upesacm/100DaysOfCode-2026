#include <stdio.h>

int findJudge(int n, int trust[][2], int trustSize) {
    int score[n + 1];

    for (int i = 1; i <= n; i++) {
        score[i] = 0;
    }

    for (int i = 0; i < trustSize; i++) {
        int a = trust[i][0];
        int b = trust[i][1];

        score[a]--;
        score[b]++;
    }

    for (int i = 1; i <= n; i++) {
        if (score[i] == n - 1) {
            return i;
        }
    }

    return -1;
}

int main() {
    int n = 3;

    int trust[][2] = {
        {1, 3},
        {2, 3}
    };

    int trustSize = 2;

    printf("%d\n", findJudge(n, trust, trustSize));

    return 0;
}